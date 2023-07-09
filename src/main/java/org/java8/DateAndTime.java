package org.java8;

import java.time.*;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate date =  LocalDate.now();
        System.out.println("Date : " + date);

        int dd = date.getDayOfMonth();

        int mm = date.getMonthValue();

        int yyyy = date.getYear();

        System.out.println(dd+"-"+mm+"-"+yyyy);

        LocalTime time = LocalTime.now();
        System.out.println("The time now is : " + time);

        int hour = time.getHour();
        int min = time.getMinute();
        int sec = time.getSecond();
        int nano = time.getNano();

        System.out.println(hour + ":" + min + ":" + sec + ":" + nano);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        System.out.println("Date 6 months form now : " + dt.plusMonths(6));
        System.out.println("Date 6 before form now : " + dt.minusMonths(6));

//        ZoneId zone =

    }
}
