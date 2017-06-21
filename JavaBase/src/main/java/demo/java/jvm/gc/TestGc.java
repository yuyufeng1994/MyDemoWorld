package demo.java.jvm.gc;

/**
 * -XX:+PrintGC 输出GC日志
 -XX:+PrintGCDetails 输出GC的详细日志
 -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 -Xloggc:../logs/gc.log 日志文件的输出路径
 -XX:+PrintGCDetails -Xloggc:../logs/gc.log -XX:+PrintGCTimeStamps

 * Created by yuyufeng on 2017/6/19.
 */
public class TestGc {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];


    public static void main(String[] args) {
        TestGc a = new TestGc();
        TestGc b = new TestGc();

        a.instance = b;
        b.instance = a;


        a = null;
        b = null;


        System.out.println("a:"+a);
        System.gc();
        System.out.println("a:"+a);

    }

}
