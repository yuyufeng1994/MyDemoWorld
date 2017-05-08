package cookbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by yuyufeng on 2017/5/8.
 * 解析一个body片断
 */
public class C_ParseHtmlBody {
    public static void main(String[] args) {
        /**
         * 存在问题:
         * 假如你有一个HTML片断 (比如. 一个 div 包含一对 p 标签; 一个不完整的HTML文档) 想对它进行解析。
         * 这个HTML片断可以是用户提交的一条评论或在一个CMS页面中编辑body部分。
         * 解决方法:
         * 使用Jsoup.parseBodyFragment(String html)方法.
         */
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
        /**
         * parseBodyFragment 方法创建一个空壳的文档，并插入解析过的HTML到body元素中。假如你使用正常的 Jsoup.parse(String html) 方法，
         * 通常你也可以得到相同的结果，但是明确将用户输入作为 body片段处理，以确保用户所提供的任何糟糕的HTML都将被解析成body元素。
         * Document.body() 方法能够取得文档body元素的所有子元素，与 doc.getElementsByTag("body")相同。
         *
         * 保证安全Stay safe
         * 假如你可以让用户输入HTML内容，那么要小心避免跨站脚本攻击。
         * 利用基于 Whitelist 的清除器和 clean(String bodyHtml, Whitelist whitelist)方法来清除用户输入的恶意内容。
         */
    }
}
