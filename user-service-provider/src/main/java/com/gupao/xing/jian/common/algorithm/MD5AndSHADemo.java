package com.gupao.xing.jian.common.algorithm;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5AndSHADemo {
    public static void main(String[] args) throws Exception {
        messageDigestAlgorithm4();
    }

    public static void  messageDigestAlgorithm4() throws Exception {
        String str = "待加密数据";
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        byte[] byteArray = str.getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        System.err.println("转换后16:\t"+hexValue+"\t长度："+hexValue.length());
    }

    public static void messageDigestAlgorithm() throws Exception {
        String str = "待加密数据待加密数据待加密数据待加密数据待加密数据待加密数据";
        //创建报文摘要实例,算法名不区分大小写SHA,Md5,sha1
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        //向已初始化的报文摘要实例提供数据
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        //计算摘要
        byte[] byteDigest = messageDigest.digest();
        //处理计算结果,计算结果s转换为16进制字符串
        String result16 = "";
        for(int i=0;i<byteDigest.length;i++){
            result16 +=Integer.toHexString((0x000000ff & byteDigest[i]) | 0xffffff00).substring(6);
        }
        System.err.println("转换后16:\t"+result16+"\t长度："+result16.length());
    }

    public static void messageDigestAlgorithm2() throws Exception {
        String str = "待加密数据";
        //创建报文摘要实例,算法名不区分大小写SHA,Md5,sha1
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //向已初始化的报文摘要实例提供数据
        //messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        //计算摘要
        byte[] byteDigest = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        //处理计算结果,计算结果s转换为16进制字符串
        String result16 = "";
        for(int i=0;i<byteDigest.length;i++){
            result16 +=Integer.toHexString((0x000000ff & byteDigest[i]) | 0xffffff00).substring(6);
        }
        System.err.println("转换后16:\t"+result16+"\t长度："+result16.length());
    }

    public static void messageDigestAlgorithm3() throws Exception {
        String str = "待加密数据";
        //创建报文摘要实例,算法名不区分大小写SHA,Md5,sha1
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //向已初始化的报文摘要实例提供数据
        //messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        //计算摘要
        byte[] byteDigest = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        //处理计算结果,计算结果s转换为16进制字符串
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String result16 = base64Encoder.encode(byteDigest);
        System.err.println("转换后16:\t"+result16+"\t长度："+result16.length());
    }
}
