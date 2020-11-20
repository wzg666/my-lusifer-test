package com.wzg.hello.maven.servlet.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName HttpUtil
 * @Description TODO
 * @Author wzg
 * Date 2020/10/15 20:11
 * Version 1.0
 */
public class HttpUtil {
    /**
     * post请求 json参数
     *
     * @param url
     * @param bodyJsonParams
     * @param headers
     * @return
     * @throws IOException
     */
    public static String doPost(String url, String bodyJsonParams, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(new StringEntity(bodyJsonParams));

        if (headers != null && headers.keySet().isEmpty()) {
            Set<String> keySet = headers.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = headers.get(key);
                httpPost.addHeader(key, value);
            }

        }
        return execute(httpPost);
    }

    /**
     * post k-v参数
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> params, Map<String, String> headers)
            throws IOException {
        HttpPost httpPost = new HttpPost(url);
        if (params != null && params.keySet().isEmpty()) {
            List<NameValuePair> list = new ArrayList<>();

            Set<String> keySet = headers.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = headers.get(key);
                list.add(new BasicNameValuePair(key, value));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(list));
        }

        if (headers != null && headers.keySet().isEmpty()) {
            Set<String> keySet = headers.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = headers.get(key);
                httpPost.addHeader(key, value);
            }

        }
        return execute(httpPost);
    }

    /**
     * get请求
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String doGet(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        // 参数
        StringBuilder paramsBuilder = new StringBuilder(url);

        if (params != null && params.keySet().isEmpty()) {
            if (url.indexOf("?") == -1) {
                paramsBuilder.append("?");
            }
            List<NameValuePair> list = new ArrayList<>();

            Set<String> keySet = headers.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = headers.get(key);
                list.add(new BasicNameValuePair(key, value));
            }
            String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(list));
            paramsBuilder.append(paramsStr);
        }
        HttpGet httpGet = new HttpGet(paramsBuilder.toString());
        // 头
        if (headers != null && headers.keySet().isEmpty()) {
            Set<String> keySet = headers.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = headers.get(key);
                httpGet.addHeader(key, value);
            }

        }
        return execute(httpGet);
    }

    /**
     * 执行请求并返回string值
     *
     * @param httpUriRequest
     * @return
     * @throws IOException
     */
    private static String execute(HttpUriRequest httpUriRequest) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse response = httpClient.execute(httpUriRequest);
            if (response.getStatusLine().getStatusCode() == 200) {// 请求成功状态
                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()))) {
                    String result="";
                    String tmp=null;
                    while((tmp=bufferedReader.readLine())!=null){
                        result+=tmp;
                    }
                    return result;
                }
            }
        }
        return null;
    }
}
