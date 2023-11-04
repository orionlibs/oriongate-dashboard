package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageLoader
{
    public void loadPage(String pageID) throws IOException
    {
        if("home".equals(pageID))
        {
            PageSetup.loadHomePage();
        }
        else if("home2".equals(pageID))
        {
            PageSetup.loadHome2Page();
        }
    }
}
