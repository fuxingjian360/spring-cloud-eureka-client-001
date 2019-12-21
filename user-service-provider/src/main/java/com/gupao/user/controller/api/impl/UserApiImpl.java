package com.gupao.user.controller.api.impl;

import com.gupao.user.api.IUserApi;
import com.gupao.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserApiImpl implements IUserApi {
    public static final AtomicInteger ids = new AtomicInteger(0);

    @Override
    public boolean saveUser(User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return false;
        }
        user.setAge(ids.incrementAndGet());
        return true;
    }

    @Override
    public Collection<User> getUsers() {
        Collection<User> list = new ArrayList<User>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(ids.incrementAndGet());
            list.add(user);
        }
        return list;
    }
}
