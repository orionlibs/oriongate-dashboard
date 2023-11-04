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
                    mainPage.setNewScene(MainClass.config.getProp("page.path.home.dashboard"));
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
