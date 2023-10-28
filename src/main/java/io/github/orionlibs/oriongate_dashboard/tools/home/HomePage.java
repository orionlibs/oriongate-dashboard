package io.github.orionlibs.oriongate_dashboard.tools.home;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javafx.application.Platform;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import netscape.javascript.JSObject;

public class HomePage extends JFrame
{
    JFXPanel javafxPanel;
    WebView webComponent;
    JPanel mainPanel;
    WebEngine webEngine;
    private HomeService homeService;
    private JavaScriptConsoleListener javaScriptConsoleListener;


    public HomePage() throws IOException
    {
        javafxPanel = new JFXPanel();
        initSwingComponents();
        loadJavaFXScene();
    }


    private void initSwingComponents() throws IOException
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        InputStream logo = HomePage.class.getResourceAsStream("/io/github/orionlibs/configuration/oriongate-dashboard/pages/images/logo.png");
        ImageIcon icon = new ImageIcon(ImageIO.read(logo));
        this.setIconImage(icon.getImage());
    }


    private void loadJavaFXScene()
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                BorderPane borderPane = new BorderPane();
                webComponent = new WebView();
                webEngine = webComponent.getEngine();
                webEngine.setJavaScriptEnabled(true);
                webEngine.setOnAlert(event -> System.out.println("JavaScript Alert: " + event.getData()));
                InputStream pageHTML = HomePage.class.getResourceAsStream("/io/github/orionlibs/configuration/oriongate-dashboard/pages/home/home.html");
                try
                {
                    webEngine.loadContent(new String(pageHTML.readAllBytes(), Charset.forName("UTF-8")));
                    borderPane.setCenter(webComponent);
                    Scene scene = new Scene(borderPane, 1920, 1080);
                    javafxPanel.setScene(scene);
                    javafxPanel.setVisible(true);
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                homeService = new HomeService(webEngine);
                javaScriptConsoleListener = new JavaScriptConsoleListener();
                webEngine.getLoadWorker().stateProperty()
                                .addListener((obs, oldValue, newValue) -> {
                                    if(newValue == State.SUCCEEDED)
                                    {
                                        //we get a reference to the DOM's window variable
                                        JSObject window = (JSObject)webEngine.executeScript("window");
                                        window.setMember("homeService", homeService);
                                        window.setMember("logger", javaScriptConsoleListener);
                                        //webEngine.executeScript("console.log = function(message) { javaConsoleListener.log(message); };");
                                    }
                                });
            }
        });
    }
}
