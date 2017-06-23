package demo.common.net.sftp;

import com.jcraft.jsch.SftpProgressMonitor;

import java.text.DecimalFormat;

/**
 * Created by yuyufeng on 2017/6/22.
 */
public class FTPMonitor implements SftpProgressMonitor {
    private long total;
    private long now = 0;
    private String fileName;


    @Override
    public void init(int i, String s, String s1, long l) {
        total = l;
        fileName = s;
    }

    @Override
    public boolean count(long l) {
        now += l;
        float per = (float) now / total * 100;
        System.out.println(String.format("%.2f", per) + "%");
        return true;
    }

    @Override
    public void end() {
        System.out.println("文件：" + fileName + "读取完毕！");
    }
}
