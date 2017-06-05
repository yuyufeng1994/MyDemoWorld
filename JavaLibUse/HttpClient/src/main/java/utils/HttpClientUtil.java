package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by yuyufeng on 2017/6/5.
 */
public class HttpClientUtil {
    private static int IDLE_TIME = 1000 * 60 * 10; // 线程池释放线程空闲 时间，单位为毫秒

    //单例lazy加载模式
    private static class HttpClientHolder {
        //创建httpclient连接池
        private static final PoolingHttpClientConnectionManager httpClientConnectionManager;

        static {
            httpClientConnectionManager = new PoolingHttpClientConnectionManager(IDLE_TIME, TimeUnit.MILLISECONDS);
            httpClientConnectionManager.setMaxTotal(200);    //设置连接池线程最大数量
            httpClientConnectionManager.setDefaultMaxPerRoute(100);//设置单个路由最大的连接线程数量 ;
        }
    }

    //请求时间参数  ;//设置请求和传输超时时间
    private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).setConnectionRequestTimeout(10000).build();//设置请求和传输超时时间

    //获取线程池
    public static PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {

        return HttpClientHolder.httpClientConnectionManager;
    }

    // 获取httpClient
    public static CloseableHttpClient getCloseableHttpClient() {

        HttpClientBuilder builder = HttpClients.custom().setConnectionManager(getPoolingHttpClientConnectionManager());

        HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                System.out.print("尝试请求次数=======" + executionCount);
                if (executionCount > 5) {
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    return false;
                }
                if (exception instanceof ConnectException) {
                    return false;
                }
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent) {
                    return true;
                }
                return false;
            }
        };
        builder.setConnectionTimeToLive(60, TimeUnit.SECONDS);
        //异常重试
        builder.setRetryHandler(myRetryHandler);
        CloseableHttpClient client = builder.build();
        return client;
    }

    /**
     * @param urlStr
     * @return
     */
    private static URI getURI(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
//			return new java.net.URI(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get请求
     *
     * @param url
     * @param byURI
     * @return
     */
    public static HttpGet doGetRequest(String url, Boolean byURI) {
        if (byURI) return new HttpGet(getURI(url));
        else return new HttpGet(url);
    }

    /**
     * post请求
     *
     * @param postUrl
     * @param byURI
     * @param postParamMap
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    private static HttpPost doPostRequest(String postUrl, Boolean byURI, Map<String, String> postParamMap) throws UnsupportedEncodingException {
//		postUrl = URLEncoder.encode(postUrl, HTTP.UTF_8);
        HttpPost post = null;
        if (byURI) post = new HttpPost(getURI(postUrl));
        else post = new HttpPost(postUrl);

        if (postParamMap != null && !postParamMap.isEmpty())
            assemblePostParam(post, postParamMap);

        return post;
    }

    /**
     * post请求
     *
     * @param postUrl
     * @param byURI
     * @param jsonParam
     * @return
     * @throws UnsupportedEncodingException
     */
    private static HttpPost doPostRequest(String postUrl, Boolean byURI, String jsonParam) throws UnsupportedEncodingException {
//		postUrl = URLEncoder.encode(postUrl, HTTP.UTF_8);
        HttpPost post = null;
        if (byURI) post = new HttpPost(getURI(postUrl));
        else post = new HttpPost(postUrl);
        assemblePostParam(post, jsonParam);

        return post;
    }

    /**
     * post提交 - 参数设置
     *
     * @param httpPost
     * @param jsonParam
     * @throws UnsupportedEncodingException
     */
    private static void assemblePostParam(HttpPost httpPost, String jsonParam) throws UnsupportedEncodingException {
        if (jsonParam == null || "".equals(jsonParam)) return;
        StringEntity entity = new StringEntity(jsonParam, "utf-8");
        entity.setContentEncoding("UTF-8");

        entity.setContentType("application/json");

        httpPost.setEntity(entity);
    }

    /**
     * post提交 - 参数设置
     *
     * @param httpPost
     * @param paramMap
     * @throws UnsupportedEncodingException
     */
    private static void assemblePostParam(HttpPost httpPost, Map<String, String> paramMap) throws UnsupportedEncodingException {
        if (paramMap == null || paramMap.isEmpty()) return;


        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entry = paramMap.entrySet();
        for (Map.Entry<String, String> map : entry) {
            nvps.add(new BasicNameValuePair(map.getKey(), map.getValue()));
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, HTTP.UTF_8);
        httpPost.setEntity(entity);
    }

    /**
     * 执行http请求，并返回响应Entity
     *
     * @param httpReq HttpPost/HttpGet
     */
    public static HttpEntity executeHttpRequest(HttpRequestBase httpReq) {

        CloseableHttpClient client = getCloseableHttpClient();
        HttpEntity entity = null;
        try {
            //设置超时参数
            httpReq.setConfig(requestConfig);
            HttpResponse httpRes = client.execute(httpReq);
            entity = httpRes.getEntity();
        } catch (ClientProtocolException e) {
            System.err.println("[http请求]----超时------");
        } catch (IOException e) {
            System.err.println("[http请求]----超时------");
        } finally {

        }
        return entity;
    }


    /**
     * @param getUrl
     * @param byURI
     * @param clazz
     * @return
     */
    public static Object doHttpResponse(String getUrl, Boolean byURI, Class<?> clazz) {
        HttpEntity entity = executeHttpRequest(doGetRequest(getUrl, byURI));
        InputStream content = null;
        if (entity != null) {
            try {
                content = entity.getContent();
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(content, clazz);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param postUrl
     * @param byURI
     * @param postParamMap
     */
    public static String doHttpResponse(String postUrl, Boolean byURI, Map<String, String> postParamMap) {
        HttpEntity entity = null;
        try {
            entity = executeHttpRequest(doPostRequest(postUrl, byURI, postParamMap));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        //InputStream content = null;
        if (entity != null) {
            try {
                //content = entity.getContent();
                return EntityUtils.toString(entity, "UTF-8");
                //return IOUtils.readStreamToString(content);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param postUrl
     * @param byURI
     * @param postParamMap
     */
    public static Object doHttpResponse(String postUrl, Boolean byURI, Map<String, String> postParamMap, Class<?> clazz) {
        HttpEntity entity = null;
        try {
            entity = executeHttpRequest(doPostRequest(postUrl, byURI, postParamMap));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        InputStream content = null;
        if (entity != null) {
            try {
                content = entity.getContent();
                //输出实体
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(content, clazz);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param postUrl
     * @param byURI
     * @param jsonParam
     * @param clazz
     * @return
     */
    public static Object doHttpResponse(String postUrl, Boolean byURI, String jsonParam, Class<?> clazz) {
        HttpEntity entity = null;
        try {
            entity = executeHttpRequest(doPostRequest(postUrl, byURI, jsonParam));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        InputStream content = null;
        if (entity != null) {
            try {
                content = entity.getContent();
                //输出实体
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(content, clazz);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param postUrl
     * @param byURI
     * @param jsonParam
     * @return
     */
    public static String doHttpResponse(String postUrl, Boolean byURI, String jsonParam) {
        HttpEntity entity = null;
        try {
            entity = executeHttpRequest(doPostRequest(postUrl, byURI, jsonParam));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        if (entity != null) {
            try {

                return EntityUtils.toString(entity, "UTF-8");

            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
