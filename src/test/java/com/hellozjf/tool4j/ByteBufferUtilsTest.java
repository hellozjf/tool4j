package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteBufferUtilsTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(ByteBufferUtilsTest.class);
    
    public static final byte[] BYTES = new byte[] {
            (byte) 0xe4, (byte) 0xbd, (byte) 0xa0, (byte) 0xe5, (byte) 0xa5, (byte) 0xbd, (byte) 0xef, (byte) 0xbc,
            (byte) 0x8c, (byte) 0xe4, (byte) 0xb8, (byte) 0x96, (byte) 0xe7, (byte) 0x95, (byte) 0x8c, (byte) 0xe3,
            (byte) 0x80, (byte) 0x82
            };
    public static final String STRING = "你好，世界。";

    @Test
    public void getByteBufferTest() {
        ByteBuffer byteBuffer = ByteBufferUtils.getByteBuffer(STRING, EncodingUtils.UTF8);
        byte[] bytes = byteBuffer.array();
        assertEquals(BYTES.length, bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            assertEquals(BYTES[i], bytes[i]);
        }
    }
    
    @Test
    public void getStringTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(BYTES);
        LOG.debug("{}", byteBuffer);
        String string = ByteBufferUtils.getString(byteBuffer);
        LOG.debug(string);
        assertEquals(STRING, string);
    }
}
