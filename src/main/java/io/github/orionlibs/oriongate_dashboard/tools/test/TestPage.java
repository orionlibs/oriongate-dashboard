package io.github.orionlibs.oriongate_dashboard.tools.test;

import io.github.orionlibs.oriongate_dashboard.Page;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestPage extends Page
{
    private static TestService homeService;
    private static Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;

    static
    {
        initialiseJavaScriptVariables();
        variableNamesToObjectsMapperToSetInJavaScript = new HashMap<>();
        variableNamesToObjectsMapperToSetInJavaScript.put("homeService", homeService);
    }

    public TestPage() throws IOException
    {
        super("/io/github/orionlibs/configuration/oriongate-dashboard/pages/test/test.html", variableNamesToObjectsMapperToSetInJavaScript);
        initialiseJavaScriptVariables();
    }


    private static void initialiseJavaScriptVariables()
    {
        homeService = new TestService();
        //homeService = new HomeService(webEngine);
    }
}
