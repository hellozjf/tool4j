package com.hellozjf.tool4j;

import java.nio.ByteBuffer;

import org.junit.Assert;
import org.junit.Test;

public class JSONUtilsTest {

    @Test
    public void isValidTest() {
        String s1 = "{";
        String s2 = "{}";
        String s3 = "{测:}";
        String s4 = "{\"测试\":123}";
        Assert.assertFalse(JSONUtils.isValid(s1));
        Assert.assertTrue(JSONUtils.isValid(s2));
        Assert.assertFalse(JSONUtils.isValid(s3));
        Assert.assertTrue(JSONUtils.isValid(s4));
        
        ByteBuffer buffer1 = ByteBufferUtils.getByteBuffer(s1);
        ByteBuffer buffer2 = ByteBufferUtils.getByteBuffer(s2);
        ByteBuffer buffer3 = ByteBufferUtils.getByteBuffer(s3, EncodingUtils.GBK);
        ByteBuffer buffer4 = ByteBufferUtils.getByteBuffer(s4, EncodingUtils.GBK);
        Assert.assertFalse(JSONUtils.isValid(buffer1));
        Assert.assertTrue(JSONUtils.isValid(buffer2));
        Assert.assertFalse(JSONUtils.isValid(buffer3, EncodingUtils.GBK));
        Assert.assertTrue(JSONUtils.isValid(buffer4, EncodingUtils.GBK));
    }
}
