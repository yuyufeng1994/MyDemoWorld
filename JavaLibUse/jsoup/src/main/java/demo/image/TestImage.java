package demo.image;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by yuyufeng on 2017/5/8.
 */
public class TestImage {
    public static void main(String[] args) throws IOException {
        int i = 10;
        while (i < 67) {
            System.out.println(i+"======================================================");
            Document doc = Jsoup.connect("http://sports.qq.com/l/basket/basketpic/page_pic/gamepic_page/nbagamepics_" + i + ".htm").get();
            i++;
            //获取后缀为jpg的图片的元素集合
            Elements elements = doc.select("img[src$=.jpg]");
            //遍历元素
            for (Element e : elements) {
//            System.out.println(e);
                String src = e.attr("src");//获取img中的src路径
                //获取后缀名
                String imageName = src.substring(src.lastIndexOf("/") + 1, src.length());
                //连接url
                try {
                    URL url = new URL(src);
                    System.out.println(imageName + " " + url);
                    downloadFile(src, "H://test/basketball/" + imageName);
                    System.out.println("保存成功：H://test/basketball/" + imageName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


//        String fileUrl = "http://bababus-resource.oss-cn-hangzhou.aliyuncs.com/manager/manaimages/2017/PC-banner-xixishidi.jpg";


//        String path = "H://test/" + new Date().getTime() + ".jpg";
//        downloadFile(fileUrl, path);
        }
    }

    /*下载图片方法*/

    public static void downloadFile(String fileUrl, String path) throws IOException {
        URL url;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return;
        }


        InputStream is;
        OutputStream os = new FileOutputStream(path);
        try {
            is = url.openStream();
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }


        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            os.write(b, 0, len);
        }
        os.close();
        is.close();

    }
}
