package com.hellozjf.tool4j;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(PathUtilsTest.class);

    @Test
    public void getProjectPathTest() {
        String projectPath = PathUtils.getProjectPath();
        LOG.debug(projectPath);
        File directory = new File("");
        String courseFile = "";
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(projectPath, courseFile);
    }

    @Test
    public void getClassLocationTest() {
        String classListClassLocation = PathUtils.getClassLocation(List.class);
        String totalClassPath = System.getProperty("sun.boot.class.path");
        LOG.debug("totalClassPath=" + totalClassPath);
        LOG.debug("File.pathSeqarator=" + File.pathSeparator);
        totalClassPath = totalClassPath.replaceAll("\\\\", "/");
        String[] classPathes = totalClassPath.split(File.pathSeparator);
        StringBuilder builder = new StringBuilder();
        for (String classPath : classPathes) {
            if (classPath.contains("/rt.jar")) {
                builder.append("jar:file:/");
                builder.append(classPath);
                builder.append("!/java/util/List.class");
                break;
            }
        }
        try {
            String decode1 = URLDecoder.decode(classListClassLocation, "utf-8");
            String decode2 = URLDecoder.decode(builder.toString(), "utf-8");
            LOG.debug("\n{}\n{}", decode1, decode2);
            assertEquals(decode1, decode2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
