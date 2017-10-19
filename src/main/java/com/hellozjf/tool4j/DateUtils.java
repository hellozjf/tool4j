package com.hellozjf.tool4j;

import java.time.Instant;
import java.time.LocalDate;
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
        Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.ofHours(hourOffset));
        return Date.from(instant);
    }

    private DateUtils() {
    }
}
