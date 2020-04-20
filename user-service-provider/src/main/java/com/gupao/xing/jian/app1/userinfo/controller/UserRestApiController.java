package com.gupao.xing.jian.app1.userinfo.controller;

import com.gupao.xing.jian.api.IUserApi;
import com.gupao.xing.jian.app1.userinfo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRestApi")
public class UserRestApiController {

    @Autowired
    public IUserApi userApi;

    @Autowired
    public TestAutoBean3 TestAutoBean3;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.err.println("xxxxxxxxx" + user.toString());
        boolean res = userApi.saveUser(user);
        if (!res) {
            user = null;
        }
        return user;
    }



    @RequestMapping(value = "/getTestUsers", method = RequestMethod.POST)
    public void getTestUsers() {
        System.out.printf(TestAutoBean3.getName());
    }

}
