package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by yuyufeng on 2017/6/5.
 */
public class HttpClientsThread {


    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient;
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);
        httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).setConnectionRequestTimeout(10000).build();//设置请求和传输超时时间

        // 创建httpget.
        HttpGet httpget = new HttpGet("http://www.bababus.com/");

        httpget.setConfig(requestConfig);
        System.out.println("executing request " + httpget.getURI());
        // 执行get请求.
        CloseableHttpResponse response = httpClient.execute(httpget);
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
}
