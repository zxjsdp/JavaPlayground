package com.moflying.playground;

import com.fasterxml.jackson.core.type.TypeReference;
import com.moflying.playground.animals.Animal;
import com.moflying.playground.utils.JsonUtil;
import com.moflying.playground.utils.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPlayground {
    /**
     * 从包含 Map 数据结构的 Json 字符串中，提取出 Map 结构体
     *
     * @return Map 结构体
     */
    private static void parseJsonMap() {
        String jsonMapString =
                "{\"2016-10-01\": \"30\",\"2016-10-02\":\"51\",\"2016-10-03\":\"68\"}";
        MapPlayground.iterateOverMapV1(parseMapFromJson(jsonMapString));
    }

    /**
     * 从 JSON 字符串中提取 Map 数据结构
     * @param mapStringJson 包含 Map 数据结构的 JSON 字符串
     * @return Map 数据结构
     */
    private static Map<String, String> parseMapFromJson(String mapStringJson) {
        Map<String, String> dailyStatsMap = new HashMap<>();
        if (StringUtil.isEmpty(mapStringJson)) {
            return dailyStatsMap;
        }

        TypeReference<Map<String, String>> typeReference =
                new TypeReference<Map<String, String>>() {};
        dailyStatsMap = JsonUtil.read(mapStringJson, typeReference);

        return dailyStatsMap;
    }

    /**
     * 从包含 List 数据结构的 Json 字符串中，提取出 List 结构体
     *
     * @return List 结构体
     */
    private static void parseJsonList() {
        String jsonListString =
                "[{\"id\":3,\"name\":\"cat\",\"gender\":\"FEMAIL\",\"color\":\"YELLOW\"}," +
                        "{\"id\":5,\"name\":\"dog\",\"gender\":\"MAIL\",\"color\":\"BLACK\"}]";

        List<Animal> animalList = parseListFromJson(jsonListString, Animal.class);
        System.out.println(animalList);
    }

    /**
     * 从 JSON 字符串中提取 List 数据结构
     * @param listStringJson 包含 List 数据结构的 JSON 字符串
     * @return List 数据结构
     */
    private static <T> List<T> parseListFromJson(String listStringJson, Class<T> type) {
        List<T> tList = new ArrayList<T>();
        if (StringUtil.isEmpty(listStringJson)) {
            return tList;
        }
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
        return JsonUtil.read(listStringJson, typeReference);
    }

    public static void main(String[] args) {
//        parseJsonMap();
        parseJsonList();
    }
}
