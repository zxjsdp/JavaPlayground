package com.moflying.playground;

import com.fasterxml.jackson.core.type.TypeReference;
import com.moflying.playground.utils.JsonUtil;
import com.moflying.playground.utils.StringUtil;

import java.util.HashMap;
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
     * @param dailyStatsJSON 包含 Map 数据结构的 JSON 字符串
     * @return Map 数据结构
     */
    private static Map<String, String> parseMapFromJson(String dailyStatsJSON) {
        Map<String, String> dailyStatsMap = new HashMap<>();
        if (StringUtil.isEmpty(dailyStatsJSON)) {
            return dailyStatsMap;
        }

        TypeReference<Map<String, String>> typeReference =
                new TypeReference<Map<String, String>>() {};
        dailyStatsMap = JsonUtil.read(dailyStatsJSON, typeReference);

        return dailyStatsMap;
    }

    public static void main(String[] args) {
        parseJsonMap();
    }
}
