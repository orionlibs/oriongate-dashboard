package io.github.orionlibs.oriongate_dashboard.utils.calendar;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTime
{
    private static final ZoneId DefaultZone = ZoneId.of("UTC");
    private Date date;
    private Time time;
    private ZoneId zoneID;


    public DateTime(ZonedDateTime zonedDateTime)
    {
        this.date = Date.of(zonedDateTime.toLocalDate(), zonedDateTime.getZone());
        this.time = Time.of(zonedDateTime.toLocalTime(), zonedDateTime.getZone());
        this.zoneID = zonedDateTime.getZone();
    }


    public static DateTime of(ZonedDateTime zonedDateTime)
    {
        return new DateTime(zonedDateTime);
    }


    public LocalDateTime toLocalDateTime()
    {
        return LocalDateTime.of(date.toLocalDate(), time.toLocalTime());
    }


    public ZonedDateTime toZonedDateTime()
    {
        return toZonedDateTime(zoneID);
    }


    public ZonedDateTime toZonedDateTime(ZoneId zone)
    {
        LocalDateTime localDateTime = toLocalDateTime();
        return localDateTime.atZone(zone);
    }


    public Instant toInstant()
    {
        return toZonedDateTime().toInstant();
    }


    public Time getTime()
    {
        return this.time;
    }


    public Date getDate()
    {
        return this.date;
    }


    public ZoneId getZoneID()
    {
        return this.zoneID;
    }
}
