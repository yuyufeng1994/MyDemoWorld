package cookbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 解析和遍历一个html文档
 * Created by yuyufeng on 2017/5/8.
 */
public class A_ParseHtmlDoc {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }
}
/**
 * 其解析器能够尽最大可能从你提供的HTML文档来创见一个干净的解析结果，无论HTML的格式是否完整。比如它可以处理：
 * 没有关闭的标签 (比如： <p>Lorem <p>Ipsum parses to <p>Lorem</p> <p>Ipsum</p>)
 * 隐式标签 (比如. 它可以自动将 <td>Table data</td>包装成<table><tr><td>?)
 * 创建可靠的文档结构（html标签包含head 和 body，在head只出现恰当的元素）
 *
 * 一个文档的对象模型
 * 文档由多个Elements和TextNodes组成 (以及其它辅助nodes：详细可查看：nodes package tree).
 * 其继承结构如下：Document继承Element继承Node. TextNode继承 Node.
 * 一个Element包含一个子节点集合，并拥有一个父Element。他们还提供了一个唯一的子元素过滤列表。
 */
