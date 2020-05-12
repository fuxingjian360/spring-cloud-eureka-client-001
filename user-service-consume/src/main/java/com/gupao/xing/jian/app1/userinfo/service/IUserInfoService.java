package com.gupao.xing.jian.app1.userinfo.service;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {
    public int addUserInfo(UserInfo userInfo) throws Exception;
    public UserInfo getUserInfoById(Long id);

    List<UserInfo> getUserInfos();
}
