package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageLoader
{
    public void loadPage(String pageID) throws IOException
    {
        if("home".equals(pageID))
        {
            Setup.loadHomePage();
        }
        else if("home2".equals(pageID))
        {
            Setup.loadHome2Page();
        }
    }
}
