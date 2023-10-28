package io.github.orionlibs.oriongate_dashboard.tools;

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
import javax.swing.JFrame;
import javax.swing.JPanel;
import netscape.javascript.JSObject;

public class HomePage extends JFrame
{
    JFXPanel javafxPanel;
    WebView webComponent;
    JPanel mainPanel;
    static WebEngine webEngine;


    public HomePage()
    {
        javafxPanel = new JFXPanel();
        initSwingComponents();
        loadJavaFXScene();
    }


    private void initSwingComponents()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
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
                webEngine.getLoadWorker().stateProperty()
                                .addListener((obs, oldValue, newValue) -> {
                                    if(newValue == State.SUCCEEDED)
                                    {
                                        //we get a reference to the DOM's window variable
                                        JSObject jsObject = (JSObject)webEngine.executeScript("window");
                                        jsObject.setMember("javaApp", new JavaApp());
                                    }
                                });
                InputStream pageHTML = HomePage.class.getResourceAsStream("/io/github/orionlibs/configuration/oriongate-dashboard/pages/home/home.html");
                try
                {
                    //webEngine.load("file:///D:/temp/home.html");
                    webEngine.loadContent(new String(pageHTML.readAllBytes(), Charset.forName("UTF-8")));
                    borderPane.setCenter(webComponent);
                    Scene scene = new Scene(borderPane, 1920, 1080);
                    javafxPanel.setScene(scene);
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    // Java class that can be accessed from JavaScript
    public static class JavaApp
    {
        public int myJavaMethod1(String message)
        {
            System.out.println("Java method called! " + message);
            // Call the JavaScript function
            //webEngine.executeScript("myFunction2()");
            webEngine.executeScript("myFunction3(\"value 4\")");
            return 64;
        }
    }
}
