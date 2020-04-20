package com.gupao.xing.jian.feign;

import com.gupao.xing.jian.app1.userinfo.domain.User;
import com.gupao.xing.jian.feign.callback.UserServiceProviderFeignCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service-provider",fallback = UserServiceProviderFeignCallBack.class)
public interface UserServiceProviderFeign {
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user);
}
