//package datasign;
//
//import org.apache.commons.lang.RandomStringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.StringUtils;
//
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class DataSignDemo2 {
//
//    static String ACCESSKEY_SECRET = "testsecret";
//
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DataSignDemo2.class);
//
//    private static final String ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss:SSSXXX";
//
//    private static  final String HTTP_METHOD_STR  = "GET&%2F&";
//    public boolean refreshObjectCaches(String filePath) {
//        if(StringUtils.isEmpty(filePath)){
//            return true;
//        }
//        Map<String, String> param =new HashMap<>();
//        param.put("Action","RefreshObjectCaches");
//        param.put("ObjectPath",filePath);
//        param.put("ObjectType","File");
//        String reqpestParam = formPublicParam(param);
//        String url = String.format("%s?%s", "http://cdn.aliyuncs.com", reqpestParam);
//        String result =  HttpRequestUnit.get(url).connectTimeout(2000).readTimeout(2000).body();
//        System.out.println("result "+result);
//
//    }
//    private static String formPublicParam(Map<String, String> requestParam) {
//        //所有的参数，这里使用TreeMap， 好处在于天然有序，默认是字母顺序
//        Map<String, String> params = new TreeMap<>();
//        params.putAll(requestParam);
//        //随机串
//        String nonce = RandomStringUtils.randomAlphanumeric(6);
//        //访问的URL
//        StringBuffer buffer = new StringBuffer();
//        for (Map.Entry<String, String> param : params.entrySet()) {
//            buffer.append(param.getKey() + "=" + param.getValue() + "&");
//        }
//
//        buffer.append("Format=JSON").append("&");
//        params.put("Format", "JSON");
//
//        buffer.append("Version=").append("2014-11-11").append("&");
//        params.put("Version", "2014-11-11");
//
//        String ACCESSKEY_ID = "testid";
//        buffer.append("AccessKeyId=").append(ACCESSKEY_ID).append("&");
//        params.put("AccessKeyId", ACCESSKEY_ID);
//
//        buffer.append("SignatureMethod=").append("HMAC-SHA1").append("&");
//        params.put("SignatureMethod", "HMAC-SHA1");
//
//        String timeStamp = DateUtils.formatDate(new Date(),ISO8601_PATTERN);
//        buffer.append("TimeStamp=").append(timeStamp).append("&");
//        params.put("TimeStamp", timeStamp);
//
//        buffer.append("SignatureVersion=1.0").append("&");
//        params.put("SignatureVersion", "1.0");
//
//        buffer.append("SignatureNonce=").append(nonce).append("&");
//        params.put("SignatureNonce", nonce);
//
//        String sign ="";
//        try {
//            sign = getSign(params);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(),e);
//        }
//        //最后拼接签名
//        buffer.append("Signature=").append(sign);
//        return buffer.toString();
//    }
//
//    private static String getSign(Map<String, String> params) throws Exception {
//        StringBuilder builder = new StringBuilder();
//        int size = 1;
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//
//            //对每个参数和值进行encode，对字符进行转义
//            String key = URLEncoder.encode(entry.getKey(), "UTF-8");
//            String value = URLEncoder.encode(entry.getValue(), "UTF-8");
//
//            builder.append(key + "=" + value);
//            if (size != params.size()) {
//                builder.append("&");
//            }
//            size++;
//        }
//        String stringToSign = HTTP_METHOD_STR+URLEncoder.encode(builder.toString(), "UTF-8");
//
//        byte[] bytes =HmacSHA1Encrypt(stringToSign, ACCESSKEY_SECRET + "&");
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(bytes);
//    }
//
//
//    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
//        Mac mac = Mac.getInstance("HmacSHA1");
//        SecretKey secretKey = new SecretKeySpec(encryptKey.getBytes(), "HmacSHA1");
//        mac.init(secretKey);
//        byte[] text = encryptText.getBytes();
//        byte[] bytes = mac.doFinal(text);
//        return bytes;
//    }
//}
