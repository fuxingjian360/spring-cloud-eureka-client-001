package com.gupao.xing.jian.proxy;

import com.gupao.xing.jian.api.IUserApi;
import com.gupao.xing.jian.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class UserServiceProxy implements IUserApi {

    public static final String provider_service_url_prefix = "http://user-service-provider/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean saveUser(User user) {
        User resUser = restTemplate.postForObject(provider_service_url_prefix + "saveUser", user, User.class);
        return resUser != null;
    }

    @Override
    public Collection<User> getUsers() {
        return restTemplate.getForObject(provider_service_url_prefix + "getUsers", Collection.class);
    }
}
