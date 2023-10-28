package io.github.orionlibs.oriongate_dashboard;

import java.util.Map;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class JavaFXRunnable implements Runnable
{
    private String pagePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;


    public JavaFXRunnable(String pagePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript)
    {
        this.pagePathToLoad = pagePathToLoad;
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
    }


    @Override
    public void run()
    {
        BorderPane borderPane = new BorderPane();
        WebView webComponent = new WebView();
        WebEngine webEngine = webComponent.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        webEngine.setOnAlert(event -> Page.javaScriptConsoleListener.error("front-end error: " + event.getData()));
        /*InputStream pageHTML = JavaFXRunnable.class.getResourceAsStream(pagePathToLoad);
        File tempFile = new File(JavaFXRunnable.class.getResource(pagePathToLoad).getPath());
        String pathToHTMLFile = tempFile.getParent();
        pathToHTMLFile = pathToHTMLFile.replace("\\", "/");
        if(pathToHTMLFile.startsWith("file:/"))
        {
            pathToHTMLFile = pathToHTMLFile.substring("file:/".length());
        }
        if(pathToHTMLFile.contains("jar!/"))
        {
            pathToHTMLFile = pathToHTMLFile.replace("jar!/", "jar/");
        }*/
        System.out.println(MainClass.applicationPath + "/oriongate-dashboard-0.0.1.jar" + pagePathToLoad);
        webEngine.load("file:///D:/temp/home/home.html");
        //webEngine.loadContent(htmlContent);
        borderPane.setCenter(webComponent);
        Scene scene = new Scene(borderPane, 1920, 1080);
        Page.javafxPanel.setScene(scene);
        Page.javafxPanel.setVisible(true);
        /*try
        {
            String htmlContent = new String(pageHTML.readAllBytes(), Charset.forName("UTF-8"));
            htmlContent = htmlContent.replace("@@path-to-this-HTML-file@@", pathToHTMLFile + "/");
            webEngine.loadContent(htmlContent);
            borderPane.setCenter(webComponent);
            Scene scene = new Scene(borderPane, 1920, 1080);
            Page.javafxPanel.setScene(scene);
            Page.javafxPanel.setVisible(true);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }*/
        webEngine.getLoadWorker().stateProperty()
                        .addListener((obs, oldValue, newValue) -> {
                            if(newValue == State.SUCCEEDED)
                            {
                                //we get a reference to the DOM's window variable
                                JSObject window = (JSObject)webEngine.executeScript("window");
                                window.setMember("logger", Page.javaScriptConsoleListener);
                                if(variableNamesToObjectsMapperToSetInJavaScript != null && !variableNamesToObjectsMapperToSetInJavaScript.isEmpty())
                                {
                                    for(Map.Entry<String, Object> variableToSet : variableNamesToObjectsMapperToSetInJavaScript.entrySet())
                                    {
                                        window.setMember(variableToSet.getKey(), variableToSet.getValue());
                                    }
                                }
                            }
                        });
    }
}
