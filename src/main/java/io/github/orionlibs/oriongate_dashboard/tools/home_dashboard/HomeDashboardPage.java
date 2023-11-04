package io.github.orionlibs.oriongate_dashboard.tools.home_dashboard;

import java.util.HashMap;
import java.util.Map;

public class HomeDashboardPage
{
    private Map<String, Object> variableNamesToObjectsMapperToSetInJavaScript;


    public HomeDashboardPage()
    {
        variableNamesToObjectsMapperToSetInJavaScript = new HashMap<>();
        variableNamesToObjectsMapperToSetInJavaScript.put("homeDashboardService", new HomeDashboardService());
    }


    public Map<String, Object> getVariableNamesToObjectsMapperToSetInJavaScript()
    {
        return variableNamesToObjectsMapperToSetInJavaScript;
    }
}
