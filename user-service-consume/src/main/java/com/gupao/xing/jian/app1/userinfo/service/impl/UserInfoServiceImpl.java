package com.gupao.xing.jian.app1.userinfo.service.impl;

import com.gupao.xing.jian.app1.student.service.IStudentService;
import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.mapper.UserInfoMapper;
import com.gupao.xing.jian.app1.userinfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfos() {
        return userInfoMapper.getUserInfos();
    }

    @Autowired
    private IStudentService studentService;

    @Override
    @Transactional(transactionManager = "db1DataSourceTransactionManager")
    public int addUserInfo(UserInfo userInfo) throws Exception {
        System.err.println("UserInfoServiceImpl.addUserInfo==>被调用");
//        if (userInfo.getName().equals("张三")) {
//            //int i = 100/0;
//            throw new Exception("主动抛出异常");
//        }
        return 10;
        //return userInfoMapper.insert(userInfo);
    }

    @Transactional(transactionManager = "db1DataSourceTransactionManager",rollbackFor = {Exception.class})
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
