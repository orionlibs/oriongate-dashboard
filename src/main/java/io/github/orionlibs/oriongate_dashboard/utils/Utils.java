package io.github.orionlibs.oriongate_dashboard.utils;

import com.google.gson.Gson;
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


    public static String convertObjectToJSON(Object objectToConvert)
    {
        return new Gson().toJson(objectToConvert);
    }


    public static String getDurationInSecondsAsFormattedDaysAndHoursAndMinutes(long numberOfSeconds)
    {
        long numberOfMinutes = numberOfSeconds / 60;
        String formattedDuration = "";
        if(numberOfMinutes < 60)
        {
            formattedDuration = Long.toString(numberOfMinutes) + " minutes";
        }
        else if(numberOfMinutes < 1440)
        {
            long numberOfHours = numberOfMinutes / 60;
            long numberOfMinutesTemp = numberOfMinutes - (numberOfHours * 60);
            formattedDuration = Long.toString(numberOfHours) + " hours";
            if(numberOfMinutesTemp != 0)
            {
                formattedDuration += " + " + Long.toString(numberOfMinutesTemp) + " minutes";
            }
        }
        else
        {
            long numberOfDays = numberOfMinutes / 1440;
            long numberOfMinutesLeft = numberOfMinutes - (numberOfDays * 1440);
            long numberOfHours = numberOfMinutesLeft / 60;
            numberOfMinutesLeft -= numberOfHours * 60;
            formattedDuration = Long.toString(numberOfDays) + " days";
            if(numberOfHours != 0)
            {
                formattedDuration += " + " + Long.toString(numberOfHours) + " hours";
            }
            if(numberOfMinutesLeft != 0)
            {
                formattedDuration += " + " + Long.toString(numberOfMinutesLeft) + " minutes";
            }
        }
        return formattedDuration;
    }
}
