package com.hellozjf.tool4j;

import java.util.ResourceBundle;

/**
 * 配置文件工具类
 * 
 * @author hellozjf
 *
 */
public class PropertiesUtils {

    /**
     * 从StringResource.properties获取字符串
     * 根据当前的语言信息，从相应的StringResource.properties中获取相应的字符串
     * 
     * @param key
     *            properties文件中的key
     * @return properties文件中的value
     */
    public static String getStringResourceValue(String key) {
        return resourceBundle.getString(key);
    }

    /**
     * 从一个文件中获取字符串 根据当前的语言信息，从相应的filePathName对应的properties文件中获取相应的字符串
     * 
     * @param filePathName
     *            需要读取的properties文件，没有后缀.properties
     * @param key
     *            properties文件中的key
     * @return properties文件中的value
     */
    public static String getPropertyValue(String filePathName, String key) {
        return ResourceBundle.getBundle(filePathName).getString(key);
    }

    private PropertiesUtils() {
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("StringResource");
}
