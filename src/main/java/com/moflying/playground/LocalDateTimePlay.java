package com.moflying.playground;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateTimePlay {
    private static void playLocalDateTime() {
        LocalDate currentDate = LocalDate.parse("2016-07-28");
        // 活动开始的日期
        LocalDate activityBeginDay = LocalDate.parse("2016-07-25");
        long daysSinceActivityBegan = ChronoUnit.DAYS.between(activityBeginDay, currentDate);
        // 活动开始前与活动已进行相同天数之前的日期, 用于比较活动活动开始前后的统计信息
        // -1 是因为活动后的数据中, 当前日期无法获取到访客量及订单等统计信息, 因此活动前的数据也应少一天
        LocalDate daySamePeriodAgoBeforeActivity = activityBeginDay.minusDays(daysSinceActivityBegan);

        System.out.println(daySamePeriodAgoBeforeActivity);
    }
    public static void main(String[] args) {
        playLocalDateTime();
    }
}
