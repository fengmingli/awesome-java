package com.lifengming.tools.reptile.common;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lifengming
 * @date 2021.09.11
 */
public class DateTimeUtil {

    public static String getDateTimeString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static void main(String[] args) {
        System.out.println(getDateTimeString());
    }
}
