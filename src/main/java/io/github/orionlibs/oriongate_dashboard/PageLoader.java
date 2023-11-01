package io.github.orionlibs.oriongate_dashboard;

public class PageLoader
{
    public void loadPage(String pageID)
    {
        if("home2".equals(pageID))
        {
            Setup.loadHome2Page();
        }
    }
}
