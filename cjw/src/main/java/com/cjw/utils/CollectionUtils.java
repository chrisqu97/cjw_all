package com.cjw.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils extends org.springframework.util.CollectionUtils {
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
