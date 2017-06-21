package demo.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/19.
 */
public class TestOutOfMemory {
    static class OOMObject {


    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
//            System.out.println(System.currentTimeMillis());
        }
    }
}


