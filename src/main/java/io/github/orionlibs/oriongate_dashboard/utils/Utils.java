package io.github.orionlibs.oriongate_dashboard.utils;

import io.github.orionlibs.oriongate_dashboard.JavaFXRunnable;
import io.github.orionlibs.oriongate_dashboard.utils.calendar.DateTime;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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


    public static int getCurrentYear()
    {
        return getCurrentDatetime().getDate().getYear();
    }


    public static DateTime getCurrentDatetime()
    {
        return DateTime.of(getCurrentZonedDatetime());
    }


    public static ZonedDateTime getCurrentZonedDatetime()
    {
        return getCurrentZonedDatetime(ZoneId.of("UTC"));
    }


    public static ZonedDateTime getCurrentZonedDatetime(ZoneId zoneID)
    {
        return ZonedDateTime.now(zoneID);
    }
}
