package io.github.orionlibs.oriongate_dashboard.utils.calendar;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class Date
{
    private int year;
    private int month;
    private int day;
    private ZoneId zoneID;


    public Date(LocalDate localDate, ZoneId zoneID)
    {
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
        this.zoneID = zoneID;
    }


    public static Date of(LocalDate localDate, ZoneId zoneID)
    {
        return new Date(localDate, zoneID);
    }


    public LocalDate toLocalDate()
    {
        return LocalDate.of(year, Month.of(month), day);
    }


    public int getYear()
    {
        return this.year;
    }


    public int getMonth()
    {
        return this.month;
    }


    public int getDay()
    {
        return this.day;
    }


    public ZoneId getZoneID()
    {
        return this.zoneID;
    }
}
