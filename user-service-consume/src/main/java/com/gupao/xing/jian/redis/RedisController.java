package com.gupao.xing.jian.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gupao.xing.jian.domain.User;
import com.gupao.xing.jian.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/redisTest")
    public String redisTest() {
        UserInfo user = new UserInfo();
        user.setId(1L);
        user.setAge(Short.valueOf("10"));
        user.setName("张三2");
        user.setSex("女");
        redisTemplate.opsForValue().set("User:002" , JSON.toJSONString(user));

        Object str = redisTemplate.opsForValue().get("User:002");
        System.err.println(str);
        return "SUCCESS";
    }

    public static void main(String[] args) {
        UserInfo user = new UserInfo();
        user.setId(1L);
        user.setAge(Short.valueOf("10"));
        user.setName("李四");
        user.setSex("女");

        System.err.println(JSON.toJSONString(user));
    }
}
