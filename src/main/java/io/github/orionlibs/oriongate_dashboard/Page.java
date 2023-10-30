package io.github.orionlibs.oriongate_dashboard;

import java.awt.BorderLayout;
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
    public static JFXPanel javafxPanel;
    public static String pageTitle = "OrionGate";
    private JPanel mainPanel;
    private String pagePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;

    static
    {
        javafxPanel = new JFXPanel();
        javaScriptConsoleListener = new FrontEndLogger();
    }

    public Page(String pagePathToLoad, Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript) throws IOException
    {
        this.pagePathToLoad = pagePathToLoad;
        this.variableNamesToObjectsMapperToSetInJavaScript = variableNamesToObjectsMapperToSetInJavaScript;
        initSwingComponents();
        loadJavaFXScene();
    }


    private void initSwingComponents() throws IOException
    {
        setTitle(pageTitle);
        setLocationByPlatform(true);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        InputStream logo = Page.class.getResourceAsStream("/configuration/images/logo.png");
        ImageIcon icon = new ImageIcon(ImageIO.read(logo));
        this.setIconImage(icon.getImage());
    }


    private void loadJavaFXScene()
    {
        Platform.runLater(new JavaFXRunnable(pagePathToLoad, variableNamesToObjectsMapperToSetInJavaScript));
    }
}
