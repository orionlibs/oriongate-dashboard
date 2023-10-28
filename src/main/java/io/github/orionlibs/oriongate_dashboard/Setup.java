package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.home.HomePage;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class Setup
{
    public static void loadHomePage()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
