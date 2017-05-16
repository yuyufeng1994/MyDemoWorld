package demo.java.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by yuyufeng on 2017/5/11.
 */
public class FunctionUse {
    public static void main(String[] args) {
//        String[] datas = new String[]{"peng", "zhao", "li"};
//        Arrays.sort(datas);
//        Stream.of(datas).forEach(param -> System.out.println(param));

        String []datas = new String[] {"peng","zhao","li"};
        Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));
    }
}
