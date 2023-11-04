package io.github.orionlibs.oriongate_dashboard.tools.home;

import io.github.orionlibs.oriongate_dashboard.MainClass;
import io.github.orionlibs.oriongate_dashboard.Page;
import java.io.IOException;

public class HomePage extends Page
{
    public HomePage() throws IOException, InterruptedException
    {
        super();
        setPagePathToLoad(MainClass.config.getProp("page.path.home"));
        initSwingComponents();
        loadJavaFXScene();
    }
}
