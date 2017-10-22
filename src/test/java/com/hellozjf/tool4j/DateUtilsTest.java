package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
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
    
    @Test 
    public void changeInstantStringToDateTest() {
        String instantString = "2017-10-22T03:56:30.123Z";
        LocalDateTime localDateTime = LocalDateTime.of(2017, 10, 22, 11, 56, 30, 123);
        Date date1 = DateUtils.changeInstantStringToDate(instantString);
        Date date2 = DateUtils.changeLocalDateTimeToDate(localDateTime, 8);
        LOG.debug("\n{}\n{}", date1, date2);
        assertEquals(date1.toString(), date2.toString());
    }
    
    @Test
    public void changeDateToInstantStringTest() {
        Date date = DateUtils.getCurrentDate(8);
        String s1 = DateUtils.changeDateToInstantString(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone(DateUtils.UTC));
        String s2 = format.format(date);
        LOG.debug("\n{}\n{}", s1, s2);
        assertEquals(s1, s2);
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
