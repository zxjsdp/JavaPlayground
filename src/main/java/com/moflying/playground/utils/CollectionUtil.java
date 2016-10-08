package com.moflying.playground.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {
    /**
     * Check if collection is null or size == 0
     * @param collection A collection
     * @return is null or empty
     */
    public static Boolean isBlank(Collection collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * Check if map is null or size == 0
     * @param map A map
     * @return is null or empty
     */
    public static Boolean isBlank(Map map) {
        return null == map || map.isEmpty();
    }
}
