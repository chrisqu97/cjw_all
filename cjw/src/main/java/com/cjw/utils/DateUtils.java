package com.cjw.utils;

import java.text.SimpleDateFormat;

public class DateUtils {
    private static SimpleDateFormat dateFormat;
    private static SimpleDateFormat dateTimeFormat;
    private static SimpleDateFormat dateOnlyFormat;
    private static SimpleDateFormat timeOnlyFormat;

    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateOnlyFormat = new SimpleDateFormat("MM-dd");
        timeOnlyFormat = new SimpleDateFormat("hh:mm:ss");
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public static SimpleDateFormat getDateTimeFormat() {
        return dateTimeFormat;
    }
}
