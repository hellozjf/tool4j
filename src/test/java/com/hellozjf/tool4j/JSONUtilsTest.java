package com.hellozjf.tool4j;

import java.nio.ByteBuffer;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONUtilsTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(JSONUtilsTest.class);

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
        LOG.debug("{}", buffer1);
        ByteBuffer buffer2 = ByteBufferUtils.getByteBuffer(s2);
        LOG.debug("{}", buffer2);
        ByteBuffer buffer3 = ByteBufferUtils.getByteBuffer(s3, EncodingUtils.GBK);
        LOG.debug("{}", buffer3);
        ByteBuffer buffer4 = ByteBufferUtils.getByteBuffer(s4, EncodingUtils.GBK);
        LOG.debug("{}", buffer4);
        
        LOG.debug("{} {}", JSONUtils.isValid(buffer1), ByteBufferUtils.getString(buffer1));
        Assert.assertFalse(JSONUtils.isValid(buffer1));
        LOG.debug("{} {}", JSONUtils.isValid(buffer2), ByteBufferUtils.getString(buffer2));
        Assert.assertTrue(JSONUtils.isValid(buffer2));
        Assert.assertFalse(JSONUtils.isValid(buffer3, EncodingUtils.GBK));
        Assert.assertTrue(JSONUtils.isValid(buffer4, EncodingUtils.GBK));
    }
}
