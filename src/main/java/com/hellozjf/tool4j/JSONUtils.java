package com.hellozjf.tool4j;

import java.nio.ByteBuffer;

import com.alibaba.fastjson.JSON;

public class JSONUtils {

    /**
     * 判断该字符串是否JSON字符串
     * 
     * @param jsonString    要判断的字符串
     * @return              true表示该字符串是JSON字符串，false表示该字符串不是JSON字符串
     */
    public static boolean isValid(String jsonString) {
        try {
            JSON.parse(jsonString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 判断ByteBuffer里的数据是否JSON字符串
     * 
     * @param buffer    要判断的ByteBuffer，编码为utf-8
     * @return              true表示该字符串是JSON字符串，false表示该字符串不是JSON字符串
     */
    public static boolean isValid(ByteBuffer buffer) {
        return isValid(buffer, "utf-8");
    }
    
    /**
     * 判断该字符串是否JSON字符串
     * 
     * @param buffer    要判断的字符串
     * @param encoding  buffer里面的编码方式
     * @return              true表示该字符串是JSON字符串，false表示该字符串不是JSON字符串
     */
    public static boolean isValid(ByteBuffer buffer, String encoding) {
        String jsonString = ByteBufferUtils.getString(buffer, encoding);
        return isValid(jsonString);
    }

    private JSONUtils() {
    }
}
