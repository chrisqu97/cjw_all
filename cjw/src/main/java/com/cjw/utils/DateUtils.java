package com.cjw.utils;

import java.text.SimpleDateFormat;

public class DateUtils {
    private static SimpleDateFormat dateFormat;
    private static SimpleDateFormat dateTimeFormat;

    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
    }

    public static SimpleDateFormat getDateFormat(){
        return dateFormat;
    }
    public static SimpleDateFormat getDateTimeFormat(){
        return dateTimeFormat;
    }
}
