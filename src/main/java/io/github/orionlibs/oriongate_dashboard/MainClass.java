package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.tools.HomePage;
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
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            }
        });
    }
}
