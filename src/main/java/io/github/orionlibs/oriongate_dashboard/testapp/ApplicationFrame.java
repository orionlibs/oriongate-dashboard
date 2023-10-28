package io.github.orionlibs.oriongate_dashboard.testapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class ApplicationFrame extends JFrame
{
    JFXPanel javafxPanel;
    WebView webComponent;
    JPanel mainPanel;
    static WebEngine webEngine;
    //JTextField urlField;
    //JButton goButton;


    public ApplicationFrame()
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
        JPanel urlPanel = new JPanel(new FlowLayout());
        /*urlField = new JTextField();
        urlField.setColumns(50);
        urlPanel.add(urlField);*/
        /*goButton = new JButton("Go");
        goButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        String url = urlField.getText();
                        if(url != null && url.length() > 0)
                        {
                            webComponent.getEngine().load(url);
                        }
                    }
                });
            }
        });
        urlPanel.add(goButton);*/
        mainPanel.add(urlPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
    }


    /**
     * Instantiate the JavaFX Components in
     * the JavaFX Application Thread.
     */
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
                                        //this prints the DOM
                                        /*org.w3c.dom.Document xmlDom = webEngine.getDocument();
                                        try
                                        {
                                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                            Transformer transformer = transformerFactory.newTransformer();
                                            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                                            StringWriter writer = new StringWriter();
                                            StreamResult result = new StreamResult(writer);
                                            transformer.transform(new DOMSource(xmlDom), result);
                                            String xmlString = writer.toString();
                                            System.out.println(xmlString);
                                        }
                                        catch(TransformerException e)
                                        {
                                            e.printStackTrace();
                                        }*/
                                    }
                                });
                webEngine.load("file:///D:/temp/form.html");
                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane, 450, 450);
                javafxPanel.setScene(scene);
            }
        });
    }


    // Java class that can be accessed from JavaScript
    public static class JavaApp
    {
        public int myJavaMethod1(String message)
        {
            System.out.println("Java method called from JavaScript! " + message);
            // Call the JavaScript function
            //webEngine.executeScript("myFunction2()");
            webEngine.executeScript("myFunction3(\"value 4\")");
            return 64;
        }
    }
}
