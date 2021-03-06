package com.gupao.xing.jian.app1.student.controller;

import com.github.pagehelper.PageInfo;
import com.gupao.xing.jian.app1.student.domain.Student;
import com.gupao.xing.jian.app1.student.domain.StudentAndUserinfo;
import com.gupao.xing.jian.app1.student.service.IStudentService;
import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app1.userinfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IUserInfoService userInfoService;

    @PostMapping("/getStudentsByPage")
    public PageInfo<Student> getStudentsByPage(){
        PageInfo<Student> lists = studentService.getStudentsByPage();
        return lists;
    }

    @PostMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudentsAndUserInfo")
    public StudentAndUserinfo getStudentsAndUserInfo(HttpServletRequest request, HttpServletResponse response,Long id) {
        Object name1 = request.getAttribute("name001");
        Object name2 = request.getAttribute("name002");
        System.err.println("name1:"+name1);
        System.err.println("name2:"+name1);
        System.err.println("id:"+id);
        //System.err.println("StudentController.getStudentsAndUserInfo()");
        StudentAndUserinfo studentAndUserinfo = new StudentAndUserinfo();
        List<Student> students = studentService.getStudents();
        List<UserInfo> userInfos = userInfoService.getUserInfos();
        studentAndUserinfo.setStudents(students);
        studentAndUserinfo.setUserInfos(userInfos);

        return studentAndUserinfo;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody @Valid Student student) throws Exception {
        String result = "F";
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

        int i = studentService.addStudentAndUser(student, userInfo);
        if (i >= 2) {
            result = "SUCCES";
        }

        return result;
    }
}