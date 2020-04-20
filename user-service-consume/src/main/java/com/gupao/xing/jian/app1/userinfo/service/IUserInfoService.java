package com.gupao.xing.jian.app1.userinfo.service;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;

public interface IUserInfoService {
    public int addUserInfo(UserInfo userInfo) throws Exception;
    public UserInfo getUserInfoById(Long id);
}
