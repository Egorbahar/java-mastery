package com.godeltech.l6pt6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZonePT {

    public static void main(String[] args) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm");

        Date now = new Date();

        TimeZone minskTimeZone = TimeZone.getTimeZone("Europe/Minsk");
        TimeZone moscowTimeZone = TimeZone.getTimeZone("Europe/Munich");
        TimeZone londonTimeZone = TimeZone.getTimeZone("Europe/London");

        System.out.println("Current time:");

        dateFormat.setTimeZone(minskTimeZone);
        System.out.println("Minsk: " + dateFormat.format(now));

        dateFormat.setTimeZone(moscowTimeZone);
        System.out.println("Munich: " + dateFormat.format(now));

        dateFormat.setTimeZone(londonTimeZone);
        System.out.println("London: " + dateFormat.format(now));
    }
}
