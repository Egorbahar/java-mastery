package com.godeltech.l6pt6;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZonePT {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm");

    public static void main(String[] args) {
        ZonedDateTime minskTimeZone = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        ZonedDateTime kievTimeZone = ZonedDateTime.now(ZoneId.of("Europe/Kiev"));
        ZonedDateTime londonTimeZone = ZonedDateTime.now(ZoneId.of("Europe/London"));

        System.out.println("Current time:");
        System.out.println("Minsk: " + dateTimeFormatter.format(minskTimeZone));
        System.out.println("Moscow: " + dateTimeFormatter.format(kievTimeZone));
        System.out.println("London: " + dateTimeFormatter.format(londonTimeZone));
    }
}
