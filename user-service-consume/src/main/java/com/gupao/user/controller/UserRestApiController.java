package com.gupao.user.controller;

import com.gupao.user.api.IUserApi;
import com.gupao.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserRestApiController {

    @Autowired
    public IUserApi userApi;

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

}
