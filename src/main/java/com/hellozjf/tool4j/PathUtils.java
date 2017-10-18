package com.hellozjf.tool4j;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * 获取各种路径
 * 
 * @author hellozjf
 *
 */
public class PathUtils {

    /**
     * 获取工程路径
     * 
     * @return 工程路径
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取类所在jar包路径或者class路径
     * 
     * @param clazz
     *            需要查找的类
     * @return 类所在jar包路径或者class路径
     */
    public static String getClassLocation(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("null input: cls");
        }
        URL result = null;
        String clsAsResource = clazz.getName().replace('.', '/').concat(".class");
        ProtectionDomain pd = clazz.getProtectionDomain();
        if (pd != null) {
            CodeSource cs = pd.getCodeSource();
            if (cs != null) {
                result = cs.getLocation();
            }
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip")) {
                            result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
                        } else if (new File(result.getFile()).isDirectory()) {
                            result = new URL(result, clsAsResource);
                        }
                    } catch (MalformedURLException ignore) {
                    }
                }
            }
        }
        if (result == null) {
            ClassLoader clsLoader = clazz.getClassLoader();
            result = clsLoader != null ? clsLoader.getResource(clsAsResource)
                    : ClassLoader.getSystemResource(clsAsResource);
        }
        return result.toString();
    }

    private PathUtils() {
    }
}
