package com.moflying.playground;

import com.google.common.base.Strings;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DateTimePlayground {
    /**
     * 从字符串中解析 LocalDateTime 的字符串格式
     *
     * 直接解析 "2016-10-01 12:09:08" 类型的字符串会抛出 DateTimeParseException。
     *
     * 1. 使用 ISO-8601 格式（ISO_LOCAL_DATE_TIME: ISO_LOCAL_DATE + "T" + ISO_LOCAL_TIME），例如："2016-10-01T12:09:08"。
     * 2. 指定 formatter 进行解析，例如：使用 "yyyy-MM-dd HH:mm:ss" 的 formatter 解析 "2016-10-01 12:09:08"。
     *
     * References:
     * - [ISO_LOCAL_DATE_TIME](http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE_TIME)
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
        LocalDate startDate = LocalDate.parse("2016-10-01");
        LocalDate endDate = LocalDate.parse("2016-10-05");
        System.out.printf("Start Date: %s; End Date: %s.\n", startDate, endDate);

        //  5 (recommended! use Math.abs)
        Long absDaysBetween3 = Math.abs(ChronoUnit.DAYS.between(endDate, startDate));
        //  5 (maybe wrong)
        Long daysBetween1 = ChronoUnit.DAYS.between(startDate, endDate);
        // -5 (maybe wrong)
        Long daysBetween2 = ChronoUnit.DAYS.between(endDate, startDate);

        System.out.printf("Abs Days between %s and %s is %d.\n", endDate, startDate, absDaysBetween3);
        System.out.printf("Days between %s and %s is %d.\n", startDate, endDate, daysBetween1);
        System.out.printf("Days between %s and %s is %d.\n", endDate, startDate, daysBetween2);
    }

    /**
     * 生成两个日期间的所有日期 [startDate, endDate)
     */
    private static void generateLocalDateWithinRange() {
        LocalDate startDate = LocalDate.parse("2016-10-01");
        LocalDate endDate = LocalDate.parse("2016-10-05");
        List<LocalDate> dateWithinRange = new ArrayList<>();
        if (null == startDate || null == endDate || !startDate.isBefore(endDate)) {
            return;
        }

        int i = 0;
        while (startDate.plusDays(i).isBefore(endDate)) {
            dateWithinRange.add(startDate.plusDays(i));
            i += 1;
        }

        // [2016-10-01, 2016-10-02, 2016-10-03, 2016-10-04]
        System.out.println(dateWithinRange);
    }

    /**
     * 将 LocalDateTime 类型转换为 LocalDate 或者 LocalTime
     */
    private static void localDateTimeToLocalDateOrLocalTime() {
        LocalDateTime now = LocalDateTime.now();

        LocalDate date = now.toLocalDate();
        LocalTime time = now.toLocalTime();

        System.out.println(date);
        System.out.println(time);
    }

    /**
     * 测试 LocalDateTime.now()，LocalDate.now() 以及 LocalTime.now() 的展示
     */
    private static void localDateTimeNowDisplay() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        // 2017-04-07T22:42:27.365
        System.out.println(localDateTime);
        // 2017-04-07
        System.out.println(localDate);
        // 22:42:27.366
        System.out.println(localTime);

        // 2017-04-07 22:42:27.441
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        // Recommended: 2017-04-07 22:42:27.441
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    }

    public static void main(String[] args) {
//        parseDateTime();
//        getStartTimeAndEndTimeOfDay();
//        getSecondsBetweenTwoTimes();
//        playCopyLocalDate();
//        getDaysBetweenTwoDates();
//        generateLocalDateWithinRange();
//        localDateTimeToLocalDateOrLocalTime();
        localDateTimeNowDisplay();
    }
}
