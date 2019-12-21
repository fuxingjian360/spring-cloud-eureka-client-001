package com.gupao.user.api;

import com.gupao.user.domain.User;

import java.util.Collection;
import java.util.List;

public interface IUserApi {

    public boolean saveUser(User user);

    public Collection<User> getUsers();
}
