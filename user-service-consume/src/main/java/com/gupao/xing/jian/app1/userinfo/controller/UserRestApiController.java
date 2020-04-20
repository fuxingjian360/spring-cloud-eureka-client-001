package com.gupao.xing.jian.app1.userinfo.controller;

import com.gupao.xing.jian.api.IUserApi;
import com.gupao.xing.jian.app1.userinfo.domain.User;
import com.gupao.xing.jian.feign.UserServiceProviderFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class UserRestApiController {

    @Autowired
    public IUserApi userApi;

    @Autowired
    public UserServiceProviderFeign userServiceProviderFeign;

    @RequestMapping(value = "/saveUserByFeign", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "errorMethod")
    public User saveUserByFeign(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        User resUser = userServiceProviderFeign.saveUser(user);
        return resUser;
    }
    public User errorMethod(String name){
        User userRes = new User();
        userRes.setName("发生错误啦");
        return userRes;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        boolean res = userApi.saveUser(user);
        if (!res) {
            user = null;
        }
        return user;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public Collection<User> getUsers() {
        Collection<User> users = userApi.getUsers();
        return users;
    }

    public String errorMethod2(String name){
        return "发生错误啦errorMethod2";
    }

}
