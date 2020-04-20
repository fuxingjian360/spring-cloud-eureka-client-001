package com.gupao.xing.jian.api;

import com.gupao.xing.jian.app1.userinfo.domain.User;

import java.util.Collection;

public interface IUserApi {

    public boolean saveUser(User user);

    public Collection<User> getUsers();
}
