package com.gupao.xing.jian.app1.userinfo.controller;

import com.gupao.xing.jian.api.IUserApi;
import com.gupao.xing.jian.app1.userinfo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRestApi")
@Api(value = "UserRestApiController", description = "用户RestAPI描述")
public class UserRestApiController {

    @Autowired
    public IUserApi userApi;

    @Autowired
    public TestAutoBean3 TestAutoBean3;

    @ApiOperation(value="保存用户", notes="保存用户描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age", value = "年龄", required = true ,dataType = "int"),
            @ApiImplicitParam(name = "name", value = "姓名", required = true ,dataType = "string")
    })
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.err.println("xxxxxxxxx" + user.toString());
        boolean res = userApi.saveUser(user);
        if (!res) {
            user = null;
        }
        return user;
    }

    @ApiOperation(value="获取用户", notes="获取用户描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true ,dataType = "string")
    })
    @RequestMapping(value = "/getTestUsers", method = RequestMethod.POST)
    public void getTestUsers(String name) {
        System.out.printf(TestAutoBean3.getName());
    }

}
