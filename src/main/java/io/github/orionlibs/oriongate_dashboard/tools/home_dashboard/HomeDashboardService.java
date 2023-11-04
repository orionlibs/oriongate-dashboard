package io.github.orionlibs.oriongate_dashboard.tools.home_dashboard;

public class HomeDashboardService
{
    public String getOperatingSystemDetails()
    {
        return System.getProperty("os.name");
    }
}
