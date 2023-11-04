package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.utils.Utils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import javafx.concurrent.Worker.State;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class JavaFXRunnable implements Runnable
{
    private String pagePathToLoad;
    private int frameWidth;
    private int frameHeight;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;
    private Group sceneContainer = new Group();
    private InputStream headerImportsHTML;
    private InputStream javascriptImportsHTML;
    private InputStream logoHTML;
    private InputStream sidebarHTML;
    private InputStream topnavbarHTML;
    private InputStream footerHTML;
    private String headerImportsHTMLContent;
    private String javascriptImportsHTMLContent;
    private String logoHTMLContent;
    private String sidebarHTMLContent;
    private String topnavbarHTMLContent;
    private String footerHTMLContent;
    private WebView webComponent;
    private String htmlContent;
    private BorderPane borderPane;


    public JavaFXRunnable(String pagePathToLoad, String headerImportsFilePathToLoad, String javascriptImportsFilePathToLoad, String logoFilePathToLoad, String sidebarFilePathToLoad, String topnavbarFilePathToLoad, String footerFilePathToLoad,
                    Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript) throws IOException
    {
        this.pagePathToLoad = pagePathToLoad;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frameWidth = screenSize.width;
        this.frameHeight = screenSize.height;
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
        headerImportsHTML = JavaFXRunnable.class.getResourceAsStream(headerImportsFilePathToLoad);
        javascriptImportsHTML = JavaFXRunnable.class.getResourceAsStream(javascriptImportsFilePathToLoad);
        logoHTML = JavaFXRunnable.class.getResourceAsStream(logoFilePathToLoad);
        sidebarHTML = JavaFXRunnable.class.getResourceAsStream(sidebarFilePathToLoad);
        topnavbarHTML = JavaFXRunnable.class.getResourceAsStream(topnavbarFilePathToLoad);
        footerHTML = JavaFXRunnable.class.getResourceAsStream(footerFilePathToLoad);
        headerImportsHTMLContent = new String(headerImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
        javascriptImportsHTMLContent = new String(javascriptImportsHTML.readAllBytes(), Charset.forName("UTF-8"));
        logoHTMLContent = new String(logoHTML.readAllBytes(), Charset.forName("UTF-8"));
        sidebarHTMLContent = new String(sidebarHTML.readAllBytes(), Charset.forName("UTF-8"));
        topnavbarHTMLContent = new String(topnavbarHTML.readAllBytes(), Charset.forName("UTF-8"));
        footerHTMLContent = new String(footerHTML.readAllBytes(), Charset.forName("UTF-8"));
    }


    @Override
    public void run()
    {
        initialiseWebContent();
        setupWebScene();
        loadContent(htmlContent, borderPane);
    }


    public void setNewScene(String newPagePathToLoad)
    {
        setPagePathToLoad(newPagePathToLoad);
        initialiseWebContent();
        loadContent(htmlContent, borderPane);
    }


    public void setNewScene(String newPagePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript)
    {
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
        setNewScene(newPagePathToLoad);
    }


    private void loadJavaObjectsToJavaScript(WebEngine webEngine)
    {
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


    private void initialiseWebContent()
    {
        InputStream pageHTML = JavaFXRunnable.class.getResourceAsStream(pagePathToLoad);
        try
        {
            htmlContent = replacePlaceholdersInHTMLContent(pageHTML);
            webComponent = initialiseJavaFXWebEngine();
            borderPane = createPanelContent();
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    private String replacePlaceholdersInHTMLContent(InputStream pageHTML) throws IOException
    {
        String htmlContent = new String(pageHTML.readAllBytes(), Charset.forName("UTF-8"));
        htmlContent = htmlContent.replace("@@base-path@@", Utils.getAbsolutePathOfResourceFile(pagePathToLoad));
        htmlContent = htmlContent.replace("@@header-imports@@", headerImportsHTMLContent);
        htmlContent = htmlContent.replace("@@javascript-imports@@", javascriptImportsHTMLContent);
        htmlContent = htmlContent.replace("@@theme@@", MainClass.config.getProp("theme.default"));
        htmlContent = htmlContent.replace("@@logo@@", logoHTMLContent);
        htmlContent = htmlContent.replace("@@sidebar@@", sidebarHTMLContent);
        htmlContent = htmlContent.replace("@@topnavbar@@", topnavbarHTMLContent);
        htmlContent = htmlContent.replace("@@footer@@", footerHTMLContent);
        htmlContent = htmlContent.replace("@@current-year@@", Integer.toString(Utils.getCurrentYear()));
        return htmlContent;
    }


    private WebView initialiseJavaFXWebEngine()
    {
        WebView webComponent = new WebView();
        WebEngine webEngine = webComponent.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.setUserAgent(MainClass.config.getProp("user.agent"));
        webEngine.setOnAlert(event -> Page.javaScriptConsoleListener.error("front-end error: " + event.getData()));
        return webComponent;
    }


    private BorderPane createPanelContent()
    {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(webComponent);
        borderPane.setMinWidth(frameWidth);
        borderPane.setMinHeight(frameHeight);
        return borderPane;
    }


    private void setupWebScene()
    {
        Scene scene = new Scene(sceneContainer);
        scene.setFill(javafx.scene.paint.Color.BLACK);
        Page.javafxPanel.setScene(scene);
    }


    private void loadContent(String htmlContent, BorderPane borderPane)
    {
        sceneContainer.getChildren().setAll(borderPane);
        webComponent.getEngine().loadContent(htmlContent);
        loadJavaObjectsToJavaScript(webComponent.getEngine());
    }


    public void setPagePathToLoad(String pagePathToLoad)
    {
        this.pagePathToLoad = pagePathToLoad;
    }
}
