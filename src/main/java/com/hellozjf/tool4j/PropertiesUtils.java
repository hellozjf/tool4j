package com.hellozjf.tool4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 配置文件工具类
 * 
 * @author hellozjf
 *
 */
public class PropertiesUtils {

    /**
     * 从classpath下的StringResource.properties获取字符串
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
     * 从classpath下的一个文件中获取字符串 根据当前的语言信息，从相应的filePathName对应的properties文件中获取相应的字符串
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
    
    /**
     * 获取user.dir下面的Property文件
     * 
     * @param folder        如果是当前目录就写.，否则写目录，用File.separator分隔目录
     * @param fileName      文件名，没有后缀.properteis
     * @return              Properties对象
     * @throws IOException  读取出现异常
     */
    public static Properties getUserDirProperty(String folder, String fileName) throws IOException {
        Properties properties = new Properties();
        String userDir = System.getProperty("user.dir");
        String file = userDir + File.separator + folder + File.separator + fileName + ".properties";
        InputStream in = new FileInputStream(file);
        properties.load(in);
        return properties;
    }
    
    /**
     * 获取user.dir下面的Property文件里面的某项value
     * 
     * @param folder        如果是当前目录就写.，否则写目录，用File.separator分隔目录
     * @param fileName      文件名，没有后缀.properteis
     * @param key           需要读取的key
     * @return              读取出来的value
     * @throws IOException  读取出现异常
     */
    public static String getUserDirPropertyValue(String folder, String fileName, String key) throws IOException {
        Properties properties = getUserDirProperty(folder, fileName);
        return properties.getProperty(key);
    }

    private PropertiesUtils() {
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("StringResource");
}
