package io.github.orionlibs.oriongate_dashboard;

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
    public static JFXPanel javafxPanel;
    public static String pageTitle = "OrionGate";
    public static String headerImportsFilePathToLoad = "/configuration/pages/common/header-imports.html";
    public static String javascriptImportsFilePathToLoad = "/configuration/pages/common/javascript-imports.html";
    public static String logoFilePathToLoad = "/configuration/pages/common/logo.html";
    public static String sidebarFilePathToLoad = "/configuration/pages/common/sidebar.html";
    public static String topnavbarFilePathToLoad = "/configuration/pages/common/topnavbar.html";
    protected JPanel mainPanel;
    private String pagePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;
    private JavaFXRunnable currentJavaFXRunnable;

    static
    {
        javafxPanel = new JFXPanel();
        javaScriptConsoleListener = new FrontEndLogger();
        pageLoader = new PageLoader();
    }

    public Page()
    {
    }


    public Page(String pagePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript) throws IOException
    {
        this.pagePathToLoad = pagePathToLoad;
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
        initSwingComponents();
        loadJavaFXScene();
    }


    public void initSwingComponents() throws IOException
    {
        setTitle(pageTitle);
        setLocationByPlatform(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLogo();
    }


    public void addPanel(JPanel panelToAdd)
    {
        setMainPanel(panelToAdd);
        this.add(panelToAdd);
        revalidate();
        repaint();
    }


    private void setLogo() throws IOException
    {
        InputStream logo = Page.class.getResourceAsStream("/configuration/images/logo.png");
        ImageIcon icon = new ImageIcon(ImageIO.read(logo));
        this.setIconImage(icon.getImage());
    }


    public void loadJavaFXScene()
    {
        currentJavaFXRunnable = new JavaFXRunnable(pagePathToLoad, headerImportsFilePathToLoad, javascriptImportsFilePathToLoad, logoFilePathToLoad, sidebarFilePathToLoad, topnavbarFilePathToLoad, variableNamesToObjectsMapperToSetInJavaScript);
        Platform.runLater(currentJavaFXRunnable);
    }


    public void setNewScene(String newPagePathToLoad)
    {
        currentJavaFXRunnable.setNewScene(newPagePathToLoad);
    }


    public void setMainPanel(JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }


    public void setPagePathToLoad(String pagePathToLoad)
    {
        this.pagePathToLoad = pagePathToLoad;
    }


    public void setVariableNamesToObjectsMapperToSetInJavaScript(Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript)
    {
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
    }
}
