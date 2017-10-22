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
    
    public static final String UTC = "UTC";         // 0时区
    public static final String CST = "CST";         // +8时区

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
    
    /**
     * 将2017-10-22T21:21:21Z这样的0时区时间转化为Date
     * 
     * @param instantString 类似于2017-10-22T21:21:21Z这样的0时区时间
     * @return Date
     */
    public static Date changeInstantStringToDate(String instantString) {
        Instant instant = Instant.parse(instantString);
        return Date.from(instant);
    }
    
    /**
     * 将Date转化为2017-10-22T21:21:21Z这样的0时区时间字符串
     * 
     * @param date 要转化的Date类型
     * @return 类似2017-10-22T21:21:21Z这样的0时区时间字符串
     */
    public static String changeDateToInstantString(Date date) {
        Instant instant = date.toInstant();
        return instant.toString();
    }

    private DateUtils() {
    }
}
