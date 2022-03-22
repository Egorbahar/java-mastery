package com.godeltech.l6pt6;

import java.util.Calendar;

public class TimeCalculationPT {

    public static void main(String[] args) throws InterruptedException {
        Calendar startCalendar = Calendar.getInstance();

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.SECOND, 10);

        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(startCalendar.getTime());

        while (currentCalendar.compareTo(endCalendar) < 0) {
            currentCalendar.add(Calendar.SECOND, 1);
            System.out.println("Current time: " + currentCalendar.getTime());

            Thread.sleep(1000);
        }
    }
}
