package com.moflying.playground;

import com.google.common.base.Strings;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DateTimePlayground {
    /**
     * 从字符串中解析 LocalDateTime 的字符串格式
     *
     * 直接解析 "2016-10-01 12:09:08" 类型的字符串会抛出 DateTimeParseException。
     * 需要制定 formatter 进行解析，或者使用 "2016-10-01T12:09:08" 的格式。
     */
    private static void parseDateTime() {
        String datetimeString1 = "2016-10-01 12:09:08";
        String datetimeString2 = "2016-10-01T12:09:08";

        // Raise java.time.format.DateTimeParseException:
        // Text '2016-10-01 12:09:08' could not be parsed at index 10
        try {
            LocalDateTime result1 = LocalDateTime.parse(datetimeString1);
            System.out.println(result1);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }

        // Success
        try {
            LocalDateTime result2 = LocalDateTime.parse(datetimeString2);
            System.out.println(result2);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }

        // Success
        try {
            LocalDateTime result3 =
                    DateTimePlayground.parseDateTime(datetimeString1, "yyyy-MM-dd HH:mm:ss");
            System.out.println(result3);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
    }

    /**
     * 从字符串中解析任意格式的日期时间
     *
     * @param datetimeString 包含日期时间信息的字符串
     * @param formatterString 字符串中的日期时间格式
     * @return LocalDateTime
     */
    private static LocalDateTime parseDateTime(String datetimeString, String formatterString) {
        if (Strings.isNullOrEmpty(datetimeString) || Strings.isNullOrEmpty(formatterString)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterString);
        return LocalDateTime.parse(datetimeString, formatter);
    }

    /**
     * 获取一天中的开始时间和结束时间
     */
    private static void getStartTimeAndEndTimeOfDay() {
        LocalTime beginTime = LocalTime.MIN;
        LocalTime endTime = LocalTime.MAX;

        System.out.println(beginTime);
        System.out.println(endTime);
    }

    /**
     * 获取目前到当天结束还剩余多少秒
     */
    private static void getSecondsBetweenTwoTimes() {
        long secondsLeftForToday = SECONDS.between(LocalTime.now(), LocalTime.MAX);
        System.out.println(secondsLeftForToday);

        long secondsLeftForTodayUseDuration = Duration.between(LocalTime.now(), LocalTime.MAX).toMinutes() * 60;
        System.out.println(secondsLeftForTodayUseDuration);
    }

    /**
     * 查看 LocalDate 的复制方式
     */
    private static void playCopyLocalDate() {
        LocalDate originalLocalDate = LocalDate.parse("2016-06-01");

        LocalDate copiedLocalDateFailed = originalLocalDate;
        LocalDate copiedLocalDateSuccess = originalLocalDate.plusDays(1).minusDays(1);

        originalLocalDate = originalLocalDate.plusDays(3);

        System.out.printf("Original LocalDate: %s\n", originalLocalDate.toString());
        System.out.printf("Copied LocalDate 1: %s\n", copiedLocalDateFailed.toString());
        System.out.printf("Copied LocalDate 2: %s\n", copiedLocalDateSuccess.toString());
    }

    /**
     * 获取两个日期之间间隔几天
     */
    private static void getDaysBetweenTwoDates() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(5);
        System.out.printf("Start Date: %s; End Date: %s.\n", startDate, endDate);

        Long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.printf("Days between %s and %s is %d.\n", startDate, endDate, daysBetween);
    }

    public static void main(String[] args) {
//        parseDateTime();
//        getStartTimeAndEndTimeOfDay();
//        getSecondsBetweenTwoTimes();
//        playCopyLocalDate();
        getDaysBetweenTwoDates();
    }
}
