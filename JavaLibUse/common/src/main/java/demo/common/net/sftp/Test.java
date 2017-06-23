package demo.common.net.sftp;

import com.jcraft.jsch.SftpException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by yuyufeng on 2017/6/22.
 */
public class Test {
    public static void main(String[] args) throws IOException, SftpException {
        SFTPUtil su = new SFTPUtil("root", "12345", "192.168.136.128", 22);
        su.login();
        su.download("/opt/myfiles/", "app.log", "d://test.txt");
        su.logout();
    }
}
