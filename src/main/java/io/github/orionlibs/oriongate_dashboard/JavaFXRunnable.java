package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.utils.Utils;
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
    private String headerImportsFilePathToLoad;
    private String javascriptImportsFilePathToLoad;
    private String logoFilePathToLoad;
    private String sidebarFilePathToLoad;
    private String topnavbarFilePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;


    public JavaFXRunnable(String pagePathToLoad, String headerImportsFilePathToLoad, String javascriptImportsFilePathToLoad, String logoFilePathToLoad, String sidebarFilePathToLoad, String topnavbarFilePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript)
    {
        this.pagePathToLoad = pagePathToLoad;
        this.headerImportsFilePathToLoad = headerImportsFilePathToLoad;
        this.javascriptImportsFilePathToLoad = javascriptImportsFilePathToLoad;
        this.logoFilePathToLoad = logoFilePathToLoad;
        this.sidebarFilePathToLoad = sidebarFilePathToLoad;
        this.topnavbarFilePathToLoad = topnavbarFilePathToLoad;
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
        InputStream pageHTML = JavaFXRunnable.class.getResourceAsStream(pagePathToLoad);
        InputStream headerImportsHTML = JavaFXRunnable.class.getResourceAsStream(headerImportsFilePathToLoad);
        InputStream javascriptImportsHTML = JavaFXRunnable.class.getResourceAsStream(javascriptImportsFilePathToLoad);
        InputStream logoHTML = JavaFXRunnable.class.getResourceAsStream(logoFilePathToLoad);
        InputStream sidebarHTML = JavaFXRunnable.class.getResourceAsStream(sidebarFilePathToLoad);
        InputStream topnavbarHTML = JavaFXRunnable.class.getResourceAsStream(topnavbarFilePathToLoad);
        try
        {
            String htmlContent = new String(pageHTML.readAllBytes(), Charset.forName("UTF-8"));
            String headerImportsHTMLContent = new String(headerImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
            String javascriptImportsHTMLContent = new String(javascriptImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
            String logoHTMLContent = new String(logoHTML.readAllBytes(), Charset.forName("UTF-8"));
            String sidebarHTMLContent = new String(sidebarHTML.readAllBytes(), Charset.forName("UTF-8"));
            String topnavbarHTMLContent = new String(topnavbarHTML.readAllBytes(), Charset.forName("UTF-8"));
            htmlContent = htmlContent.replace("@@base-path@@", Utils.getAbsolutePathOfResourceFile(pagePathToLoad));
            htmlContent = htmlContent.replace("@@header-imports@@", headerImportsHTMLContent);
            htmlContent = htmlContent.replace("@@javascript-imports@@", javascriptImportsHTMLContent);
            htmlContent = htmlContent.replace("@@theme@@", MainClass.config.getProp("theme.default"));
            htmlContent = htmlContent.replace("@@logo@@", logoHTMLContent);
            htmlContent = htmlContent.replace("@@sidebar@@", sidebarHTMLContent);
            htmlContent = htmlContent.replace("@@topnavbar@@", topnavbarHTMLContent);
            htmlContent = htmlContent.replace("@@current-year@@", Integer.toString(Utils.getCurrentYear()));
            webEngine.loadContent(htmlContent);
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
                                //set variables inside JavaScript
                                window.setMember("logger", Page.javaScriptConsoleListener);
                                window.setMember("pageLoader", Page.pageLoader);
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


    public void setNewScene(String newPagePathToLoad)
    {
        pagePathToLoad = newPagePathToLoad;
        BorderPane borderPane = new BorderPane();
        WebView webComponent = new WebView();
        WebEngine webEngine = webComponent.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        webEngine.setOnAlert(event -> Page.javaScriptConsoleListener.error("front-end error: " + event.getData()));
        InputStream pageHTML = JavaFXRunnable.class.getResourceAsStream(pagePathToLoad);
        InputStream headerImportsHTML = JavaFXRunnable.class.getResourceAsStream(headerImportsFilePathToLoad);
        InputStream javascriptImportsHTML = JavaFXRunnable.class.getResourceAsStream(javascriptImportsFilePathToLoad);
        InputStream logoHTML = JavaFXRunnable.class.getResourceAsStream(logoFilePathToLoad);
        InputStream sidebarHTML = JavaFXRunnable.class.getResourceAsStream(sidebarFilePathToLoad);
        InputStream topnavbarHTML = JavaFXRunnable.class.getResourceAsStream(topnavbarFilePathToLoad);
        try
        {
            String htmlContent = new String(pageHTML.readAllBytes(), Charset.forName("UTF-8"));
            String headerImportsHTMLContent = new String(headerImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
            String javascriptImportsHTMLContent = new String(javascriptImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
            String logoHTMLContent = new String(logoHTML.readAllBytes(), Charset.forName("UTF-8"));
            String sidebarHTMLContent = new String(sidebarHTML.readAllBytes(), Charset.forName("UTF-8"));
            String topnavbarHTMLContent = new String(topnavbarHTML.readAllBytes(), Charset.forName("UTF-8"));
            htmlContent = htmlContent.replace("@@base-path@@", Utils.getAbsolutePathOfResourceFile(pagePathToLoad));
            htmlContent = htmlContent.replace("@@header-imports@@", headerImportsHTMLContent);
            htmlContent = htmlContent.replace("@@javascript-imports@@", javascriptImportsHTMLContent);
            htmlContent = htmlContent.replace("@@theme@@", MainClass.config.getProp("theme.default"));
            htmlContent = htmlContent.replace("@@logo@@", logoHTMLContent);
            htmlContent = htmlContent.replace("@@sidebar@@", sidebarHTMLContent);
            htmlContent = htmlContent.replace("@@topnavbar@@", topnavbarHTMLContent);
            htmlContent = htmlContent.replace("@@current-year@@", Integer.toString(Utils.getCurrentYear()));
            webEngine.loadContent(htmlContent);
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
                                //set variables inside JavaScript
                                window.setMember("logger", Page.javaScriptConsoleListener);
                                window.setMember("pageLoader", Page.pageLoader);
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


    public void setPagePathToLoad(String pagePathToLoad)
    {
        this.pagePathToLoad = pagePathToLoad;
    }
}
