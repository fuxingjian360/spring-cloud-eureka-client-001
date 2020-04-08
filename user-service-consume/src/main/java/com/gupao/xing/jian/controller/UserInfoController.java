package com.gupao.xing.jian.controller;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.service.IUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private IUserInfo userInfoService;

    @PostMapping("/addUserInfo")
    public String addUserInfo() throws Exception{
        String result = "F";
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三2");
        userInfo.setAge(new Short("18"));
        userInfo.setSex("女");
        int i = userInfoService.addUserInfo(userInfo);
        if (i > 0) {
            result = "SUCCESS";
        }
        return result;
    }

    @GetMapping("/getUserInfo")
    public UserInfo getUserInfo(Long id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        return userInfo;
    }

}
