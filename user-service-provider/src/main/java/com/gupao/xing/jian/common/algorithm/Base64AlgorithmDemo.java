package com.gupao.xing.jian.common.algorithm;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * base64算法
 */
public class Base64AlgorithmDemo {
    public static void main(String[] args) {
        base64();
    }
    public static void base64(){
        String str = "健a\\=. 编码与解码测试付";
        System.err.println("原文:\t" + str+"\t长度为"+str.length());
        byte[] strByte = str.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        try {
            String strEncoder = encoder.encodeToString(strByte);
            System.err.println("编码后:\t"+strEncoder+"\t长度为"+strEncoder.length());

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] byteDecoder = decoder.decode(strEncoder);
            String strDecoder = new String(byteDecoder,StandardCharsets.UTF_8);
            System.err.println("解密后\t"+strDecoder+"\t长度为"+strDecoder.length());

            Base64.Encoder urlEncode = Base64.getUrlEncoder();
            String strUrlEncode = urlEncode.encodeToString(strByte);
            System.err.println("url加密后\t"+strUrlEncode+"\t长度为"+strUrlEncode.length());

            Base64.Decoder urlDecoder = Base64.getUrlDecoder();
            byte[] urlByte = urlDecoder.decode(strUrlEncode);
            String strUrlDecoder = new String(urlByte,StandardCharsets.UTF_8);
            System.err.println("url解密后\t"+strUrlDecoder+"\t长度为"+strUrlDecoder.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
