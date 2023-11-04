package io.github.orionlibs.oriongate_dashboard;

import io.github.orionlibs.oriongate_dashboard.config.ConfigurationService;
import io.github.orionlibs.oriongate_dashboard.config.OrionConfiguration;
import java.io.File;
import java.io.IOException;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
public class MainClass
{
    public static ConfigurationService config;
    public static String applicationPath;

    static
    {
        //determines the actual path of the executing JAR file for this application.
        applicationPath = new File(MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getAbsolutePath();
        applicationPath = applicationPath.replace("\\", "/");
    }

    public static void main(String[] args) throws IOException
    {
        InitialSetup.loadHomePageAsBootstrapPage();
        config = new ConfigurationService();
        setupConfiguration();
    }


    private static void setupConfiguration() throws IOException
    {
        config.registerConfiguration(OrionConfiguration.loadFeatureConfiguration());
    }
}
