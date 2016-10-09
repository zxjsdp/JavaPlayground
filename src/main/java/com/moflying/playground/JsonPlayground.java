package com.moflying.playground;

import com.fasterxml.jackson.core.type.TypeReference;
import com.moflying.playground.animals.Animal;
import com.moflying.playground.entities.FoodSalesInfo;
import com.moflying.playground.utils.JsonUtil;
import com.moflying.playground.utils.StringUtil;

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
    private static void parseJsonList1() {
        String jsonListString =
                "[{\"id\":3,\"name\":\"cat\",\"gender\":\"FEMAIL\",\"color\":\"YELLOW\"}," +
                        "{\"id\":5,\"name\":\"dog\",\"gender\":\"MAIL\",\"color\":\"BLACK\"}]";

        List<Animal> animalList = JsonUtil.readList(jsonListString, Animal.class);
        System.out.println(animalList);
    }

    private static void parseJsonList2() {
        String foodBasicVolumnInfoJSON =
                "[{\"foodId\":\"111111\",\"foodName\":\"糖醋里脊\",\"totalSalesVolumn\":\"17\"}," +
                        "{\"foodId\":\"222222\",\"foodName\":\"宫保鸡丁\",\"totalSalesVolumn\":\"34\"}]";

        List<FoodSalesInfo> foodBasicVolumnInfoList =
                JsonUtil.readList(foodBasicVolumnInfoJSON, FoodSalesInfo.class);

        System.out.println(foodBasicVolumnInfoList);
    }


    public static void main(String[] args) {
//        parseJsonMap();
//        parseJsonList1();
        parseJsonList2();
    }
}

