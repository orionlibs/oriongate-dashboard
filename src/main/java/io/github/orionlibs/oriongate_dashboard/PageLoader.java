package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageLoader
{
    public void loadPage(String pageID) throws IOException
    {
        if("page1".equals(pageID))
        {
            PageSetup.loadPage1();
        }
        else if("page2".equals(pageID))
        {
            PageSetup.loadPage2();
        }
    }
}
