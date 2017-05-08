package demo.bababus;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 爬取巴巴快巴我的订单
 * Created by yuyufeng on 2017/5/8.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Map<String, String> cookies = null;
        Map<String, String> datas = new HashMap<>();
        Connection conn = Jsoup.connect("http://account.demo.bababus.com/pc/login.htm");
        conn.method(Connection.Method.POST);
        conn.followRedirects(false);
        datas.put("account", "13574472507");
        datas.put("password", "yyfyyf1994");
        datas.put("isRememberMe", "1");
        conn.data(datas);
        conn.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36");
        Connection.Response response = conn.execute();
        cookies = response.cookies();


       /* for (String s : cookies.keySet()) {
            System.out.println(s + " " + cookies.get(s));
        }*/
        int page = 1;
        int sum = 0;

        while (true) {
            Document doc = Jsoup.connect("http://bus.demo.bababus.com/order/list.htm")
                    .data("queryType", "0")
                    .data("orderType", "T")
                    .data("page", page + "")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36")
                    .cookies(cookies)
                    .post();
//        System.out.println(doc);
            Elements orders = doc.getElementsByClass("personal_order_tb");
            if (orders.size() < 1) {
                System.out.println("查询结束 累计订单数量：" + sum);
                return;
            }
            for (Element order : orders) {
                String route = order.getElementsByClass("personal_order_star").text();
                String time = order.getElementsByClass("personal_order_price").text();
                String name = order.getElementsByClass("personal_order_type").text();
                String number = order.getElementsByClass("personal_order_number").text();
                String price = order.getElementsByClass("personal_order_allprice").text();


                System.out.println("路线：" + route);
                System.out.println("出发时间：" + time);
                System.out.println("姓名：" + name);
                System.out.println("数量：" + number);
                System.out.println("价格：" + price);


                System.out.println("=========================================");
                sum++;
            }
            page++;
        }
    }

}
