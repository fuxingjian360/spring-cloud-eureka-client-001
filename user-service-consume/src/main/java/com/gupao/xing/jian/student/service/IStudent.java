package com.gupao.xing.jian.student.service;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.student.domain.Student;

public interface IStudent {
    public int addStudent(Student student) throws Exception;
    public Student getStudentById(Long id);
    public int addStudentAndUser(Student student, UserInfo userInfo) throws Exception;
}

