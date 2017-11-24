package com.teamwork.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 */

/**
 * 网络请求工具类
 */
public class AuthUtil {

    public static final String APPID = "wx9e6052614f95005b";//appid
    public static final String APPSECRET = "32c2dadebea8f5dd3eab7b0ee90fb50e";//secretid

    /**
     * get请求 返回json对象数据
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject json = null;
        CloseableHttpClient client;//创建连接对象
        if(url.startsWith("https")){//是否为https
            client = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        }else{//http
            client = HttpClients.createDefault();
        }
        HttpGet httpGet = new HttpGet(url);//get请求
        HttpResponse response = client.execute(httpGet);//发送get请求 获取返回值
        HttpEntity entity = response.getEntity();
        if(entity!=null){
            String result = EntityUtils.toString(entity,"UTF-8");
            json = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();//释放连接
        return json;
    }
}

