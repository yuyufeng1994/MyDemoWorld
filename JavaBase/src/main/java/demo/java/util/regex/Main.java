package demo.java.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuyufeng on 2017/5/11.
 */
public class Main {
    public static void main(String[] args) {
        //从一个给定的字符串中找到数字串
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
