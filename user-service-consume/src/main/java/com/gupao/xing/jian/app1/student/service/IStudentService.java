package com.gupao.xing.jian.app1.student.service;

import com.github.pagehelper.PageInfo;
import com.gupao.xing.jian.app1.student.domain.Student;
import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.common.exception.MyRuntimeException;

import java.util.List;

public interface IStudentService {
    public int addStudent(Student student) throws MyRuntimeException;
    public Student getStudentById(Long id);
    public int addStudentAndUser(Student student, UserInfo userInfo) throws Exception;

    PageInfo<Student> getStudentsByPage();

    List<Student> getStudents();
}

