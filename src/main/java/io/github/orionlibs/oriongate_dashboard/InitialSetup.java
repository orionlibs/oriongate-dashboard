package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.home.HomePage;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class InitialSetup
{
    public static HomePage homePage;


    public static void loadHomePageAsBootstrapPage()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    homePage = new HomePage();
                    homePage.setVisible(true);
                }
                catch(IOException | InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
