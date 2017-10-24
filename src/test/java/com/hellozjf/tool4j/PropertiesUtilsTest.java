package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Test;

public class PropertiesUtilsTest {

    @Test
    public void getStringResourceValueTest() {
        String value = PropertiesUtils.getStringResourceValue("test.string");
        assertEquals(value, "teststring");
    }
    
    @Test
    public void getPropertyValueTest() {
        String value = PropertiesUtils.getPropertyValue("StringResource", "test.string");
        assertEquals(value, "teststring");
    }
    
    @Test
    public void getUserDirPropertyTest() throws Exception {
        Properties properties = PropertiesUtils.getUserDirProperty("conf", "StringResource");
        assertEquals("teststring", properties.getProperty("test.string"));
    }
    
    @Test
    public void getUserDirPropertyValueTest() throws Exception {
        String value = PropertiesUtils.getUserDirPropertyValue("conf", "StringResource", "test.string");
        assertEquals("teststring", value);
    }
}
