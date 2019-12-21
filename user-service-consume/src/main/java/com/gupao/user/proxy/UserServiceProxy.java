package com.gupao.user.proxy;

import com.gupao.user.api.IUserApi;
import com.gupao.user.domain.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

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
