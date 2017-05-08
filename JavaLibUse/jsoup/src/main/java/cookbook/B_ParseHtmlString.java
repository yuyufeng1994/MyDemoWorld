package cookbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by yuyufeng on 2017/5/8.
 * 解析一个HTML字符串
 */
public class B_ParseHtmlString {
    public static void main(String[] args) {
        /**
         * 存在问题:
         * 来自用户输入，一个文件或一个网站的HTML字符串，你可能需要对它进行解析并取其内容，或校验其格式是否完整，或想修改它。
         * 怎么办？jsonu能够帮你轻松解决这些问题
         * 解决方法:
         * 使用静态Jsoup.parse(String html) 方法或 Jsoup.parse(String html, String baseUri)示例代码：
         */
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);

        /**
         * 描述
         * parse(String html, String baseUri) 这方法能够将输入的HTML解析为一个新的文档 (Document），
         * 参数 baseUri 是用来将相对 URL 转成绝对URL，并指定从哪个网站获取文档。如这个方法不适用，
         * 你可以使用 parse(String html) 方法来解析成HTML字符串如上面的示例。.
         * 只要解析的不是空字符串，就能返回一个结构合理的文档，其中包含(至少) 一个head和一个body元素。
         * 一旦拥有了一个Document，你就可以使用Document中适当的方法或它父类 Element和Node中的方法来取得相关数据。
         */
    }
}
