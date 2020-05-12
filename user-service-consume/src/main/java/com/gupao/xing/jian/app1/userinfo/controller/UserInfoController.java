package com.gupao.xing.jian.app1.userinfo.controller;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response,Long id) {
        UserInfo userInfo = null;
        String path = request.getServletPath();
        if(id.intValue()==10){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/getStudentsAndUserInfo");
            try {
                request.setAttribute("name001","value001");
                request.setAttribute("name002","value002");
                //请求重定向，request相同对象
                requestDispatcher.forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(id.intValue()==11){
            try {
                request.setAttribute("name001","value001");
                request.setAttribute("name002","value002");
                //请求转发，request不同对象
                response.sendRedirect("/student/getStudentsAndUserInfo");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            userInfo = userInfoService.getUserInfoById(id);
    }
        return userInfo;
    }

}
