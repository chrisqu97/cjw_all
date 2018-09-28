package com.cjw.utils;

public class StringUtils extends org.springframework.util.StringUtils {
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
