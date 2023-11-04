package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageSetup
{
    public static void loadHomePage() throws IOException
    {
        InitialSetup.homePage.setNewScene(MainClass.config.getProp("page.path.home"));
    }


    public static void loadHome2Page() throws IOException
    {
        InitialSetup.homePage.setNewScene(MainClass.config.getProp("page.path.home2"));
    }
}
