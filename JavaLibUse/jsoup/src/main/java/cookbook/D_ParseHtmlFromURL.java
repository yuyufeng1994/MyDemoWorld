package cookbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * 从一个URL加载一个Document
 * 你需要从一个网站获取和解析一个HTML文档，并查找其中的相关数据。
 * Created by yuyufeng on 2017/5/8.
 */
public class D_ParseHtmlFromURL {
    public static void main(String[] args) throws IOException {
       /* Document doc = Jsoup.connect("http://example.com/").get();
        String title = doc.title();*/

        /**
         * connect(String url) 方法创建一个新的 Connection, 和 get() 取得和解析一个HTML文件。
         * 如果从该URL获取HTML时发生错误，便会抛出 IOException，应适当处理。
         * Connection 接口还提供一个方法链来解决特殊请求，具体如下：
         */

        Document doc = Jsoup.connect("http://www.qq.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();

        System.out.println(doc);

        /**
         * 这个方法只支持Web URLs (http和https 协议); 假如你需要从一个文件加载，可以使用 parse(File in, String charsetName) 代替。
         */
    }
}
