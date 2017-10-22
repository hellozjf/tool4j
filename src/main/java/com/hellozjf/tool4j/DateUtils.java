package com.hellozjf.tool4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 时间工具类
 * 
 * 将本地日期时间与Date类进行转化
 * 
 * @author hellozjf
 *
 */
public class DateUtils {

    /**
     * 将LocalDate转化为Date
     * 
     * 转化的时候时间默认为0:00:00
     * 
     * @param localDate
     *            日期
     * @param hourOffset
     *            时区
     * @return 0时区的Date
     */
    public static Date changeLocalDateToDate(LocalDate localDate, int hourOffset) {
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return changeLocalDateTimeToDate(localDateTime, 8);
    }

    /**
     * 将LocalDateTime转化为Date
     * 
     * 转化的时候时间默认为0:00:00
     * 
     * @param localDateTime
     *            日期和时间
     * @param hourOffset
     *            时区
     * @return 0时区的Date
     */
    public static Date changeLocalDateTimeToDate(LocalDateTime localDateTime, int hourOffset) {
        Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(hourOffset));
        return Date.from(instant);
    }

    /**
     * 获取当前的Date
     * 
     * @param hourOffset
     *            时区
     * @return 0时区的Date
     */
    public static Date getCurrentDate(int hourOffset) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return changeLocalDateTimeToDate(localDateTime, hourOffset);
    }

    private DateUtils() {
    }
}
