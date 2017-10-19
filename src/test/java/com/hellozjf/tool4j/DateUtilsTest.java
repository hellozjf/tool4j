package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
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
        
        Calendar calendarFromDate = Calendar.getInstance();
        calendarFromDate.setTime(date);
        
        assertEquals(calendarFromNow.get(Calendar.YEAR), calendarFromDate.get(Calendar.YEAR));
        assertEquals(calendarFromNow.get(Calendar.MONTH), calendarFromDate.get(Calendar.MONTH));
        assertEquals(calendarFromNow.get(Calendar.DAY_OF_MONTH), calendarFromDate.get(Calendar.DAY_OF_MONTH));
        LOG.debug("\n{}\n{}", calendarFromNow.getTimeZone(), calendarFromDate.getTimeZone());
        assertEquals(calendarFromNow.getTimeZone().getRawOffset(), calendarFromDate.getTimeZone().getRawOffset());
    }
}
