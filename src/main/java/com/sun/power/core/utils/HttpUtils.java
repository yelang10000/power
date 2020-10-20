package com.sun.power.core.utils;



import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 模拟发包请求
 */
public class HttpUtils {

    /**
     *  请求超时时间,这个时间定义了socket读数据的超时时间
     */
    private static final int SOCKET_TIME_OUT = 60000;
    /**
     * 连接超时时间,这个时间定义了通过网络与服务器建立连接的超时时间
     */
    private static final int CONNECT_TIME_OUT = 60000;

    private static PoolingHttpClientConnectionManager cm;

    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            // 整个连接池最大连接数
            cm.setMaxTotal(50);
            // 每路由最大连接数，默认值是5
            cm.setDefaultMaxPerRoute(5);
        }
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(cm).build();
    }

    /**
     * 发送  post 请求
     *      适用于发送json数据的请求
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static String post(String url, String param, Map<String, Object> headers) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = getHttpClient();
        StringEntity entity = null;
        try {
            if (param != null) {
                HttpPost req = new HttpPost(url);

                if (headers != null && headers.size() > 0) {
                    //setHeader,添加头文件
                    Set<String> keys = headers.keySet();
                    for (String key : keys) {
                        req.setHeader(key, headers.get(key).toString());
                    }
                }
                entity = new StringEntity(param);
                entity.setContentEncoding("UTF-8");

                //setConfig,添加配置,如设置请求超时时间,连接超时时间
                RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIME_OUT).setConnectTimeout(CONNECT_TIME_OUT).build();
                req.setConfig(reqConfig);
                req.setEntity(entity);
                response = client.execute(req);
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                if (response.getStatusLine().getStatusCode() == 200) {
                    return result;
                }
            }
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                }
            }
        }
        return null;
    }


    /**
     * 发送  post 请求
     *      适用于发送json数据的请求
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static String get(String url,Map<String, Object> headers) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = getHttpClient();
        try {
            HttpGet req = new HttpGet(url);
            //setConfig,添加配置,如设置请求超时时间,连接超时时间
            RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIME_OUT).setConnectTimeout(CONNECT_TIME_OUT).build();
            req.setConfig(reqConfig);
            response = client.execute(req);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (response.getStatusLine().getStatusCode() == 200) {
                return result;
            }
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                }
            }
        }
        return null;
    }






}
