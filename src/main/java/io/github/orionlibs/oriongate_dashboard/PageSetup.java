package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageSetup
{
    public static void loadHomeDashboard() throws IOException
    {
        InitialSetup.mainPage.setNewScene(MainClass.config.getProp("page.path.home.dashboard"));
    }
}
