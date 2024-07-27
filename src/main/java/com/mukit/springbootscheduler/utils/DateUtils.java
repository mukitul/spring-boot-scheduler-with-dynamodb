package com.mukit.springbootscheduler.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtils {

    public static long currentTimeInMillis() {
        return Instant.now().toEpochMilli();
    }

    public static long getStartOfDayEpoch(int dayOffset) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime targetDateTime = currentDateTime.plusDays(dayOffset).toLocalDate().atStartOfDay();

        ZonedDateTime startOfDay = targetDateTime.atZone(ZoneId.systemDefault());

        return startOfDay.toEpochSecond();
    }

}
