package io.github.orionlibs.oriongate_dashboard.testapp;

import javax.swing.SwingUtilities;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Getter
@Setter
public class Testapp1
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ApplicationFrame mainFrame = new ApplicationFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
