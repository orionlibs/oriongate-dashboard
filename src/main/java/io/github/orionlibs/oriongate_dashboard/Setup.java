package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.home.HomePage;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class Setup
{
    private static HomePage homePage;


    public static void loadHomePage()
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
                    //TestPage homePage = new TestPage();
                    //homePage.setVisible(true);
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    public static void loadHome2Page()
    {
        //homePage.loadHome2Page();
    }
}
