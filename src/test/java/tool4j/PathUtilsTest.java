package tool4j;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.hellozjf.tool4j.PathUtils;


public class PathUtilsTest {

    @Test
    public void getProjectPathTest() {
        String projectPath = PathUtils.getProjectPath();
        File directory = new File("");
        String courseFile = "";
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(projectPath, courseFile);
    }
}
