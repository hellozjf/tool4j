package com.hellozjf.tool4j;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * ByteBuffer实用小工具
 * 
 * 目前这个小工具的作用就是将ByteBuffer与String进行转换
 * 
 * @author hellozjf
 *
 */
public class ByteBufferUtils {
    
    /**
     * 将字符串按照一定的编码，转化为ByteBuffer
     * 
     * @param str           要转化的字符串
     * @param encoding      要转化的编码格式
     * @return              ByteBuffer
     */
    public static ByteBuffer getByteBuffer(String str, String encoding) {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes(encoding));
            buffer.position(buffer.capacity());
            return buffer;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串按照utf-8编码，转化为ByteBuffer
     * 
     * @param str           要转化的字符串
     * @return              ByteBuffer
     */
    public static ByteBuffer getByteBuffer(String str) {
        return getByteBuffer(str, EncodingUtils.UTF8);
    }

    /**
     * 将ByteBuffer按照编码，转化为字符串
     * 
     * @param buffer        要转化的ByteBuffer
     * @param encoding      要转化的编码
     * @return              字符串
     */
    public static String getString(ByteBuffer buffer, String encoding) {
        try {
            return new String(buffer.array(), 0, buffer.position(), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 将ByteBuffer按照utf-8编码，转化为字符串
     * 
     * @param buffer        要转化的ByteBuffer
     * @return              字符串
     */
    public static String getString(ByteBuffer buffer) {
        return getString(buffer, EncodingUtils.UTF8);
    }

    private ByteBufferUtils() {
    }
}
