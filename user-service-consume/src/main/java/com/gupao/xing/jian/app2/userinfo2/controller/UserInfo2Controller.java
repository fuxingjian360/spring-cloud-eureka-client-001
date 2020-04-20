package com.gupao.xing.jian.app2.userinfo2.controller;

import com.github.pagehelper.PageInfo;
import com.gupao.xing.jian.app1.student.domain.Student;
import com.gupao.xing.jian.app2.userinfo2.domain.UserInfo2;
import com.gupao.xing.jian.app2.userinfo2.service.IUserInfo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userInfo2")
public class UserInfo2Controller {

    @Autowired
    private IUserInfo2Service userInfo2Service;

    @PostMapping("/getUserInfo2sByPage")
    public PageInfo<UserInfo2> getUserInfo2sByPage(){
        PageInfo<UserInfo2> lists = userInfo2Service.getUserInfo2sByPage();
        return lists;
    }

    @PostMapping("/getUserInfo2s")
    public List<UserInfo2> getUserInfo2s(){
        return userInfo2Service.getUserInfo2s();
    }

    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Long id) {
        System.err.println(id);
        return userInfo2Service.deleteByPrimaryKey(id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody UserInfo2 userInfo2) throws Exception{
        int i = 0;
        i = userInfo2Service.insert(userInfo2);

        return i;
    }

    @PostMapping("/selectByPrimaryKey")
    public UserInfo2 selectByPrimaryKey(Long id) {
        System.err.println(id);
        return userInfo2Service.selectByPrimaryKey(id);
    }

}
