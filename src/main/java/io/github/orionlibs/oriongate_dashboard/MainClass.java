package io.github.orionlibs.oriongate_dashboard;

import java.io.File;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
public class MainClass
{
    public static String applicationPath;

    static
    {
        //determines the actual path of the executing JAR file for this application.
        applicationPath = new File(MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getAbsolutePath();
        applicationPath = applicationPath.replace("\\", "/");
    }

    public static void main(String[] args)
    {
        Setup.loadHomePage();
    }
}
