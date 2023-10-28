package io.github.orionlibs.oriongate_dashboard.utils;

import io.github.orionlibs.oriongate_dashboard.JavaFXRunnable;
import java.net.URL;

public class Utils
{
    public static String getAbsolutePathOfResourceFile(String pagePathToLoad)
    {
        URL pageHTMLAsURL = JavaFXRunnable.class.getResource(pagePathToLoad);
        String pageHTMLAsURLString = pageHTMLAsURL.toString();
        if(pageHTMLAsURLString.startsWith("file:/"))
        {
            pageHTMLAsURLString = "file:///" + pageHTMLAsURLString.substring("file:/".length());
        }
        else if(pageHTMLAsURLString.startsWith("jar:file:/"))
        {
            pageHTMLAsURLString = "jar:file:///" + pageHTMLAsURLString.substring("jar:file:/".length());
        }
        return pageHTMLAsURLString.substring(0, pageHTMLAsURLString.lastIndexOf("/") + 1);
    }
}
