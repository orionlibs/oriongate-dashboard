package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;
import javax.swing.SwingUtilities;

public class InitialSetup
{
    public static Page mainPage;


    public static void loadHomePageAsBootstrapPage()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    mainPage = new Page();
                    mainPage.setPagePathToLoad(MainClass.config.getProp("page.path.home"));
                    mainPage.loadJavaFXScene();
                    mainPage.setVisible(true);
                }
                catch(IOException | InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
