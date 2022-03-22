package com.godeltech.l6pt6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculationPT {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss");

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusSeconds(10);
        System.out.print("Start time: " + startTime + "\n" + "End time: " + endTime);
        calculateTime(startTime, endTime);
    }

    private static void calculateTime(LocalDateTime startTime, LocalDateTime endTime) {
        int second = 0;
        LocalDateTime currentTime = LocalDateTime.now();
        while (Duration.between(currentTime, endTime).toSeconds() > 0) {
            currentTime = startTime.plusSeconds(second);
            System.out.println("Current time: " + currentTime.format(dateTimeFormatter));
            second++;
        }
    }
}
