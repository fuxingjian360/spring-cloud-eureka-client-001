package com.gupao.xing.jian.app2.userinfo2.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gupao.xing.jian.app2.userinfo2.domain.UserInfo2;
import com.gupao.xing.jian.app2.userinfo2.mapper.UserInfo2Mapper;
import com.gupao.xing.jian.app2.userinfo2.service.IUserInfo2Service;
import com.gupao.xing.jian.common.exception.MyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfo2ServiceImpl implements IUserInfo2Service {

    @Autowired
    private UserInfo2Mapper userInfo2Mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfo2Mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional("db2DataSourceTransactionManager")
    public int insert(UserInfo2 record) throws MyRuntimeException {
        int i = userInfo2Mapper.insert(record);
        if (record.getName().equals("张三")) {
            throw new MyRuntimeException();
        }
        return i;
    }

    @Override
    public UserInfo2 selectByPrimaryKey(Long id) {
        return userInfo2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<UserInfo2> getUserInfo2sByPage() {
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(1, 3);
        List<UserInfo2> lists = userInfo2Mapper.getUserInfo2s();
        PageInfo<UserInfo2> pageInfo = new PageInfo<UserInfo2>(lists);
        return pageInfo;
    }

    @Override
    public List<UserInfo2> getUserInfo2s() {
        return userInfo2Mapper.getUserInfo2s();
    }
}
