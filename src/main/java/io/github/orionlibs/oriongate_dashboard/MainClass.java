package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.home.HomePage;
import java.io.IOException;
import javax.swing.SwingUtilities;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Getter
@Setter
public class MainClass
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                HomePage homePage = null;
                try
                {
                    homePage = new HomePage();
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
