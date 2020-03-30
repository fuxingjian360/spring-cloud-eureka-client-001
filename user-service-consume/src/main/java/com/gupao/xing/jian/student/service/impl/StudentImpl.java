package com.gupao.xing.jian.student.service.impl;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.service.IUserInfo;
import com.gupao.xing.jian.student.domain.Student;
import com.gupao.xing.jian.student.mapper.StudentMapper;
import com.gupao.xing.jian.student.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentImpl implements IStudent {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private IUserInfo userInfoService;

    @Override
    @Transactional
    public int addStudentAndUser(Student student, UserInfo userInfo) throws Exception {
        int i= this.addStudent(student);
        int j = userInfoService.addUserInfo(userInfo);
        return i+j;
    }

    @Override
    @Transactional
    public int addStudent(Student student) throws Exception{
        if(student.getName().equals("张三")){
            throw new Exception();
        }
        return studentMapper.insert(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
