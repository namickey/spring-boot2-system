package com.example.orange.common.util;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class DateUtil {
    
    public static LocalDate create(String date) {
        if (!StringUtils.hasText(date)) {
            return null;
        }
        int year = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(2, 4));
        int day = Integer.parseInt(date.substring(4, 8));
        
        return LocalDate.of(year, month, day);
    }
}
