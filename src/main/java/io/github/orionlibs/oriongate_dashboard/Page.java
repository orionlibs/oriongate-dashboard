package io.github.orionlibs.oriongate_dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page extends JFrame
{
    public static FrontEndLogger javaScriptConsoleListener;
    public static PageLoader pageLoader;
    public static JPanel mainPanel;
    public static JFXPanel javafxPanel;
    public static String pageTitle;
    public static String headerImportsFilePathToLoad;
    public static String javascriptImportsFilePathToLoad;
    public static String logoFilePathToLoad;
    public static String sidebarFilePathToLoad;
    public static String topnavbarFilePathToLoad;
    public static String footerFilePathToLoad;
    private String pagePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;
    private JavaFXRunnable currentJavaFXRunnable;

    static
    {
        pageTitle = "OrionGate";
        headerImportsFilePathToLoad = MainClass.config.getProp("common.component.path.header.imports");
        javascriptImportsFilePathToLoad = MainClass.config.getProp("common.component.path.javascript.imports");
        logoFilePathToLoad = MainClass.config.getProp("common.component.path.logo");
        sidebarFilePathToLoad = MainClass.config.getProp("common.component.path.sidebar");
        topnavbarFilePathToLoad = MainClass.config.getProp("common.component.path.topnavbar");
        footerFilePathToLoad = MainClass.config.getProp("common.component.path.footer");
        javafxPanel = new JFXPanel();
        mainPanel = new JPanel();
        javaScriptConsoleListener = new FrontEndLogger();
        pageLoader = new PageLoader();
    }

    public Page() throws IOException
    {
        initSwingComponents();
    }


    public void initSwingComponents() throws IOException
    {
        setTitle(pageTitle);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLogo();
        mainPanel.setBackground(Color.decode(MainClass.config.getProp("window.background.color")));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        add(mainPanel);
    }


    private void setLogo() throws IOException
    {
        InputStream logo = Page.class.getResourceAsStream(MainClass.config.getProp("logo.path"));
        ImageIcon icon = new ImageIcon(ImageIO.read(logo));
        setIconImage(icon.getImage());
    }


    public void loadJavaFXScene() throws IOException
    {
        currentJavaFXRunnable = new JavaFXRunnable(pagePathToLoad, headerImportsFilePathToLoad, javascriptImportsFilePathToLoad, logoFilePathToLoad, sidebarFilePathToLoad, topnavbarFilePathToLoad, footerFilePathToLoad, variableNamesToObjectsMapperToSetInJavaScript);
        Platform.runLater(currentJavaFXRunnable);
    }


    public void setNewScene() throws IOException
    {
        if(currentJavaFXRunnable == null)
        {
            loadJavaFXScene();
        }
        else
        {
            currentJavaFXRunnable.setNewScene(pagePathToLoad);
        }
        if(!isVisible())
        {
            setVisible(true);
        }
    }


    public void setNewScene(String newPagePathToLoad) throws IOException
    {
        setPagePathToLoad(newPagePathToLoad);
        setNewScene();
    }


    public void setNewScene(String newPagePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript) throws IOException
    {
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
        setNewScene(newPagePathToLoad);
    }


    public void setPagePathToLoad(String pagePathToLoad)
    {
        this.pagePathToLoad = pagePathToLoad;
    }
}
