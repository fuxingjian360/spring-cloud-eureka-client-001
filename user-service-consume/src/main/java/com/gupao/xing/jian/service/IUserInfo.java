package com.gupao.xing.jian.service;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.student.domain.Student;

public interface IUserInfo {
    public int addUserInfo(UserInfo userInfo) throws Exception;
    public UserInfo getUserInfoById(Long id);
}
