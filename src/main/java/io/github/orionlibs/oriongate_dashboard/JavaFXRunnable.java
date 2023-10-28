package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
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
        webEngine.setOnAlert(event -> Page.javaScriptConsoleListener.logError("front-end error: " + event.getData()));
        InputStream pageHTML = JavaFXRunnable.class.getResourceAsStream(pagePathToLoad);
        try
        {
            webEngine.loadContent(new String(pageHTML.readAllBytes(), Charset.forName("UTF-8")));
            borderPane.setCenter(webComponent);
            Scene scene = new Scene(borderPane, 1920, 1080);
            Page.javafxPanel.setScene(scene);
            Page.javafxPanel.setVisible(true);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
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
