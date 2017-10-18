package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

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
}
