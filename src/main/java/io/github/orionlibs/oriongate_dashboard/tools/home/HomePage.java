package io.github.orionlibs.oriongate_dashboard.tools.home;

import io.github.orionlibs.oriongate_dashboard.Page;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomePage extends Page
{
    private static HomeService homeService;
    private static Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;

    static
    {
        initialiseJavaScriptVariables();
        variableNamesToObjectsMapperToSetInJavaScript = new HashMap<>();
        variableNamesToObjectsMapperToSetInJavaScript.put("homeService", homeService);
    }

    public HomePage() throws IOException
    {
        super("/io/github/orionlibs/configuration/oriongate-dashboard/pages/home/home.html", variableNamesToObjectsMapperToSetInJavaScript);
        initialiseJavaScriptVariables();
    }


    private static void initialiseJavaScriptVariables()
    {
        homeService = new HomeService();
        //homeService = new HomeService(webEngine);
    }
}
