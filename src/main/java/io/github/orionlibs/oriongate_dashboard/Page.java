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
    public static JavaScriptConsoleListener javaScriptConsoleListener;
    public static JFXPanel javafxPanel;
    private JPanel mainPanel;
    private String pagePathToLoad;
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;

    static
    {
        javafxPanel = new JFXPanel();
        javaScriptConsoleListener = new JavaScriptConsoleListener();
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        InputStream logo = Page.class.getResourceAsStream("/io/github/orionlibs/configuration/oriongate-dashboard/pages/images/logo.png");
        ImageIcon icon = new ImageIcon(ImageIO.read(logo));
        this.setIconImage(icon.getImage());
    }


    private void loadJavaFXScene()
    {
        Platform.runLater(new JavaFXRunnable(pagePathToLoad, variableNamesToObjectsMapperToSetInJavaScript));
    }
}
