package com.gupao.xing.jian.service.impl;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.mapper.UserInfoMapper;
import com.gupao.xing.jian.service.IUserInfo;
import com.gupao.xing.jian.student.domain.Student;
import com.gupao.xing.jian.student.service.IStudent;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoImpl implements IUserInfo {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private IStudent studentService;

    @Override
    @Transactional
    public int addUserInfo(UserInfo userInfo) throws Exception {
        if (userInfo.getName().equals("张三")) {
            //int i = 100/0;
            throw new Exception("主动抛出异常");
        }
        return userInfoMapper.insert(userInfo);
    }

    @Transactional(rollbackFor = {Exception.class})
    protected int addUserInfo2(UserInfo userInfo) throws Exception {
        if (userInfo.getName().equals("张三")) {
            throw new Exception("主动抛出异常");
        }
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
