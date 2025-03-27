import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ToolsTest {
    @Test
    void testReadFile() {
        String path = "res/data_test/readFile.txt";
        try {
            String content = Tools.readFile(path);
            assertEquals(content, "ceci est un test.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWriteFile() {
        String content = "Ceci est un test.";
        String path = "res/data_test/testWrite";
        try {
            Tools.writeFile(path, content);
            assertEquals(content, Tools.readFile(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
