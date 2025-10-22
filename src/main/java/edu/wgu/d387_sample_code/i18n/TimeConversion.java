package edu.wgu.d387_sample_code.i18n;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TimeConversion {

    public static Map<String, String> getTimeConversion(){

        //setting timezones for ET, MT, UTC and system time
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUTC = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        //getting local time
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        //wrapping that time to ZonedDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        //takes the time instant and converts it to the zones, then strips timezone info to text
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();

        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();

        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();

        //linked list to hold the timezone names and corresponding values
        Map<String, String> times = new LinkedHashMap<>();
        times.put("Eastern Time", localDateTimeEastern.toString());
        times.put("Mountain Time", localDateTimeMountain.toString());
        times.put("UTC", localDateTimeUTC.toString());
        //debugging to view console output before sending to REST controller
        System.out.println(times);

        return times;

    }
}
