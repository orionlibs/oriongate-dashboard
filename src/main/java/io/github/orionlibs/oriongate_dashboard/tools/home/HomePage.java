package io.github.orionlibs.oriongate_dashboard.tools.home;

import io.github.orionlibs.oriongate_dashboard.Page;
import java.io.IOException;

public class HomePage extends Page
{
    public HomePage() throws IOException
    {
        super("/io/github/orionlibs/configuration/oriongate-dashboard/pages/home/home.html", null);
    }
}
