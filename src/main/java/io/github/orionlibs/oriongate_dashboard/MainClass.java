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
        applicationPath = new File(MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getAbsolutePath();
    }

    public static void main(String[] args)
    {
        Setup.loadHomePage();
    }
}
