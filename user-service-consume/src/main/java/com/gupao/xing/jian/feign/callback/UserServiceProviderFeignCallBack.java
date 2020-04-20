package com.gupao.xing.jian.feign.callback;

import com.gupao.xing.jian.app1.userinfo.domain.User;
import com.gupao.xing.jian.feign.UserServiceProviderFeign;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProviderFeignCallBack implements UserServiceProviderFeign {
    @Override
    public User saveUser(User user) {
        user.setName("XXX错误啦");
        return user;
    }
}
