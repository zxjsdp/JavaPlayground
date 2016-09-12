package com.moflying.playground;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LocalDateTimePlayground {
    /**
     * 获取两个日期间的天数，日期减法
     */
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

    /**
     * 生成两个日期间的所有日期 [startDate, endDate)
     *
     * @param startDate 起始日期
     * @param endDate 结束日期
     * @return 两个日期间的所有日期
     */
    private static List<LocalDate> generateLocalDateWithinRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dateWithinRange = new ArrayList<>();
        if (null == startDate || null == endDate || !startDate.isBefore(endDate)) {
            return dateWithinRange;
        }

        int i = 0;
        while (startDate.plusDays(i).isBefore(endDate)) {
            dateWithinRange.add(startDate.plusDays(i));
            i += 1;
        }

        // StartDate: 2016-09-12
        //   EndDate: 2016-09-16
        // DateRange: [2016-09-12, 2016-09-13, 2016-09-14, 2016-09-15]
        System.out.println("StartDate: " + startDate);
        System.out.println("  EndDate: " + endDate);
        System.out.println("DateRange: " + dateWithinRange);

        return dateWithinRange;
    }

    public static void main(String[] args) {
//        playLocalDateTime();
        generateLocalDateWithinRange(LocalDate.now(), LocalDate.now().plusDays(4));
    }
}
