package com.gupao.xing.jian.student.controller;

import com.gupao.xing.jian.domain.UserInfo;
import com.gupao.xing.jian.service.IUserInfo;
import com.gupao.xing.jian.student.domain.Student;
import com.gupao.xing.jian.student.service.IStudent;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudent studentService;

    @Autowired
    private IUserInfo userInfoService;

    @PostMapping("/addStudent")
    public String addStudent() throws Exception {
        String result = "F";
        Student student = new Student();
        student.setName("李四");
        student.setScore(BigDecimal.valueOf(10000));
        student.setStndengClass("三班");
        student.setStudentNum(100);
        student.setCreateDate(new Date(System.currentTimeMillis()));
        student.setUpdateDate(new Date(System.currentTimeMillis()));
        int i = studentService.addStudent(student);
        if (i > 0) {
            result = "SUCCES";
        }

        return result;
    }

    @GetMapping("/getStudent")
    public Student getStudent(long id) {
        return studentService.getStudentById(id);
    }


    @PostMapping("/addStudentTranstion")
    public String addStudentTranstion() throws Exception {
        String result = "F";
        Student student = new Student();
        student.setName("李四");
        student.setScore(BigDecimal.valueOf(10000));
        student.setStndengClass("三班");
        student.setStudentNum(100);
        student.setCreateDate(new Date(System.currentTimeMillis()));
        student.setUpdateDate(new Date(System.currentTimeMillis()));

        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setAge(new Short("18"));
        userInfo.setSex("女");

        int i = studentService.addStudentAndUser(student,userInfo);
        if (i >=2) {
            result = "SUCCES";
        }

        return result;
    }


}
