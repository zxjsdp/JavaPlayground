package com.moflying.playground;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DateTimePlayground {
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

    public static void main(String[] args) {
//        getStartTimeAndEndTimeOfDay();
//        getSecondsBetweenTwoTimes();
        playCopyLocalDate();
    }
}
