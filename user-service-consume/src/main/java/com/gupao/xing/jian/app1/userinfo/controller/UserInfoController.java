package com.gupao.xing.jian.app1.userinfo.controller;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @PostMapping("/addUserInfo")
    public String addUserInfo(@RequestBody UserInfo userInfo) throws Exception {
        String result = "F";
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
