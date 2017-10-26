package com.hellozjf.tool4j;

import org.junit.Assert;
import org.junit.Test;

public class XMLUtilsTest {

    @Test
    public void isValidTest() {
        String s1 = "<hello></hello>";
        String s2 = "<test</test>";
        Assert.assertTrue(XMLUtils.isValid(s1));
        Assert.assertFalse(XMLUtils.isValid(s2));
    }
}
