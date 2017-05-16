package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/5/16.
 */
public class GetPostTest {

    @Test
    public void testGet() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpget.
        HttpGet httpget = new HttpGet("http://127.0.0.1/json/get-data/1");
        System.out.println("executing request " + httpget.getURI());
        // 执行get请求.
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
                System.out.println("Response: " + entity);
                // 打印响应内容
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }
        } finally {
            response.close();
        }
    }

    @Test
    public void testPost() throws IOException {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://127.0.0.1/json/post-data");
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("userId", "2"));
        formparams.add(new BasicNameValuePair("userName", "用户2"));
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");

        // 创建参数队列
//       HttpEntity httpEntity = new StringEntity("");
        httppost.setEntity(uefEntity);
        System.out.println("executing request " + httppost.getURI());
        CloseableHttpResponse response = httpclient.execute(httppost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
            }
        } finally {
            response.close();
        }
    }


    @Test
    public void test() {
        System.out.println("Main.test");
    }
}
