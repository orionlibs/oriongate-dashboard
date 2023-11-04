package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;

public class PageLoader
{
    public void loadPage(String pageID) throws IOException
    {
        if("homeDashboard".equals(pageID))
        {
            PageSetup.loadHomeDashboard();
        }
    }
}
