package com.gupao.xing.jian.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gupao.xing.jian.common.http.ResultVO;
import io.micrometer.core.instrument.util.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class HttpClientTest {
    public static void main(String[] args) {
        //String reqUrl= "/userInfo2/getUserInfo2s";
        String reqUrl= "/student/getStudentsAndUserInfo";
        getResponseByHttp("localhost", 8080, reqUrl);
    }

    /**
     * reqUrl:/XXX/XX
     *
     * @param host
     * @param port
     * @param reqUrl
     */
    public static void getResponseByHttp(String host,
                                         int port,
                                         String reqUrl) {
        HttpHost httpHost = new HttpHost(host, port);
        reqUrl = httpHost + reqUrl;
        HttpPost httpPost = new HttpPost(URI.create(reqUrl));

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            //响应编码
            int rspCode = httpResponse.getStatusLine().getStatusCode();
            //响应头
            Header[] heads = httpResponse.getAllHeaders();
            List<Header> headsList = Arrays.asList(heads);
            //响应体
            InputStream inputStream = httpEntity.getContent();
            String rspBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            ResultVO res = JSONObject.toJavaObject((JSON) JSON.parse(rspBody), ResultVO.class);
            //ResultVO.StudentAndUserinfo studentAndUserinfo = res.getData();
            //List<ResultVO.Student> students = studentAndUserinfo.getStudents();
           // List<ResultVO.UserInfo> userInfos = studentAndUserinfo.getUserInfos();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
