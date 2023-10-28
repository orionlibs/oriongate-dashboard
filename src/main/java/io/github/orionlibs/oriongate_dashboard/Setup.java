package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.test.TestPage;
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
                    TestPage homePage = new TestPage();
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
