package core;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yuyufeng on 2017/5/10.
 */
public class FileUtilTest {


    @Test
    public void test() {
        System.out.println("FileUtilTest.test");
    }

    @Test
    public void testFileSystemResource() throws IOException {
        String filePath =
                "D:///test.txt";
        // ① 使用系统文件路径方式加载文件
        Resource res1 = new FileSystemResource(filePath);
        // ② 使用类路径方式加载文件
        Resource res2 = new ClassPathResource("messages/exceptions.properties");
        InputStream ins1 = res1.getInputStream();
        InputStream ins2 = res2.getInputStream();
        System.out.println("res1:" + res1.getFilename());
        System.out.println("res2:" + res2.getFilename());
    }
}
