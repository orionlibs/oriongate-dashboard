package io.github.orionlibs.oriongate_dashboard.testapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame
{
    JFXPanel javafxPanel;
    WebView webComponent;
    JPanel mainPanel;
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
                webComponent.getEngine().load("file:///D:/temp/form.html");
                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane, 450, 450);
                javafxPanel.setScene(scene);
            }
        });
    }
}
