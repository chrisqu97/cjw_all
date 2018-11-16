package com.cjw.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class CollectionUtils extends org.springframework.util.CollectionUtils {
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static void addAll(Collection collection, Iterator iterator) {
        while(iterator.hasNext()) {
            collection.add(iterator.next());
        }
    }
}
