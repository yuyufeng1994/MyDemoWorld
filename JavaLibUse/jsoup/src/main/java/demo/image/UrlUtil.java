package demo.image;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by yuyufeng on 2017/5/8.
 */
public class UrlUtil {

    public static void main(String[] args) throws IOException {
        getUrl("http://www.qq.com");
    }

    public static void getUrl(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        for (Element link : links) {
            System.out.println(link.attr("abs:href") + " " + trim(link.text(), 35));
        }

    }


    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1) + ".";
        else
            return s;
    }
}
