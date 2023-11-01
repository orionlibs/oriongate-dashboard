package io.github.orionlibs.oriongate_dashboard.utils.calendar;

import java.time.LocalTime;
import java.time.ZoneId;

public class Time
{
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;
    private ZoneId zoneID;


    public Time(LocalTime localTime, ZoneId zoneID)
    {
        this.hours = localTime.getHour();
        this.minutes = localTime.getMinute();
        this.seconds = localTime.getSecond();
        this.milliseconds = localTime.getNano() / 1_000_000;
        this.zoneID = zoneID;
    }


    public static Time of(LocalTime localTime, ZoneId zoneID)
    {
        return new Time(localTime, zoneID);
    }


    public LocalTime toLocalTime()
    {
        return LocalTime.of(hours, minutes, seconds, (milliseconds * 1_000_000));
    }


    public int getHours()
    {
        return this.hours;
    }


    public int getMinutes()
    {
        return this.minutes;
    }


    public int getSeconds()
    {
        return this.seconds;
    }


    public int getMilliseconds()
    {
        return this.milliseconds;
    }


    public ZoneId getZoneID()
    {
        return this.zoneID;
    }
}
