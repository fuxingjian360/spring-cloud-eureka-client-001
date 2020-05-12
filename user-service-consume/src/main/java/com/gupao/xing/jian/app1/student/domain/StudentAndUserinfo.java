package com.gupao.xing.jian.app1.student.domain;

import com.gupao.xing.jian.app1.userinfo.domain.UserInfo;
import com.gupao.xing.jian.app2.userinfo2.domain.UserInfo2;

import java.io.Serializable;
import java.util.List;

public class StudentAndUserinfo implements Serializable {
    private List<Student> students;
    private List<UserInfo> userInfos;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
