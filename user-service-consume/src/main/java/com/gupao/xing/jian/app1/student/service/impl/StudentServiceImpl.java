package com.gupao.xing.jian.app1.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.service.IUserInfoService;
import com.gupao.xing.jian.app1.student.domain.Student;
import com.gupao.xing.jian.app1.student.mapper.StudentMapper;
import com.gupao.xing.jian.app1.student.service.IStudentService;
import com.gupao.xing.jian.common.exception.MyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public PageInfo<Student> getStudentsByPage() {
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(1, 5);
        List<Student> lists = studentMapper.getStudents();
        PageInfo<Student> pageInfo = new PageInfo<Student>(lists);
        return pageInfo;
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    @Override
    @Transactional(transactionManager = "db1DataSourceTransactionManager")
    public int addStudentAndUser(Student student, UserInfo userInfo) throws Exception {
        int i= this.addStudent(student);
        int j = userInfoService.addUserInfo(userInfo);
        return i+j;
    }

    @Override
    @Transactional(transactionManager = "db1DataSourceTransactionManager")
    public int addStudent(Student student) throws MyRuntimeException{
        int i = studentMapper.insert(student);
        if(student.getName().equals("张三")){
            throw new MyRuntimeException();
        }
        return i;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
