package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    public void changeLocalDateToDateTest() {
        LocalDate localDate = LocalDate.now();
        Date date = DateUtils.changeLocalDateToDate(localDate, 8);

        Calendar calendarFromNow = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("+8")));
        calendarFromNow.set(Calendar.HOUR_OF_DAY, 0);
        calendarFromNow.set(Calendar.MINUTE, 0);
        calendarFromNow.set(Calendar.SECOND, 0);
        calendarFromNow.set(Calendar.MILLISECOND, 0);

        Calendar calendarFromDate = Calendar.getInstance();
        calendarFromDate.setTime(date);

        assertCalendarEqual(calendarFromNow, calendarFromDate);
    }

    @Test
    public void changeLocalDateTimeToDateTest() {

        // 通过LocalDateTime.now()和Calendar.getInstance()获取当前的时间
        LocalDateTime localDateTime = LocalDateTime.now();
        Calendar calendarFromNow = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("+8")));

        // 通过现在的LocalDateTime获得现在的Calendar
        Calendar calendarFromDate = Calendar.getInstance();
        Date date = DateUtils.changeLocalDateTimeToDate(localDateTime, 8);
        calendarFromDate.setTime(date);

        assertCalendarEqual(calendarFromNow, calendarFromDate);
    }

    @Test
    public void getCurrentDateTest() {
        Date date = DateUtils.getCurrentDate(8);
        Calendar calendarFromNow = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("+8")));
        Calendar calendarFromDate = Calendar.getInstance();
        calendarFromDate.setTime(date);

        assertCalendarEqual(calendarFromNow, calendarFromDate);
    }

    private void assertCalendarEqual(Calendar c1, Calendar c2) {
        assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
        assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
        assertEquals(c1.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.DAY_OF_MONTH));
        assertEquals(c1.get(Calendar.HOUR_OF_DAY), c2.get(Calendar.HOUR_OF_DAY));
        assertEquals(c1.get(Calendar.MINUTE), c2.get(Calendar.MINUTE));
        assertEquals(c1.get(Calendar.SECOND), c2.get(Calendar.SECOND));
        // 不比较毫秒，因为毫秒肯定不同
        // assertEquals(c1.get(Calendar.MILLISECOND), c2.get(Calendar.MILLISECOND));
        LOG.debug("\n{}\n{}", c1.getTimeZone(), c2.getTimeZone());
        assertEquals(c1.getTimeZone().getRawOffset(), c2.getTimeZone().getRawOffset());
    }
}
