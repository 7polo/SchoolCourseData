package com.apologizebao.bean;

/**
 * Created by apologizebao on 16-12-20.
 */
public class CourseBean {
//    数据结构<br>
//    周一第1,2节{第1-17周}<br>
//    左开中/郭良敏<br>
//    1号楼2010308<br/>
    
    private String courseName;
    private String courseTime;
    private String courserTeacher;
    private String courseAddr;

    public CourseBean() {
    }

    public CourseBean(String courseName, String courseTime, String courserTeacher, String courseAddr) {
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courserTeacher = courserTeacher;
        this.courseAddr = courseAddr;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourserTeacher() {
        return courserTeacher;
    }

    public void setCourserTeacher(String courserTeacher) {
        this.courserTeacher = courserTeacher;
    }

    public String getCourseAddr() {
        return courseAddr;
    }

    public void setCourseAddr(String courseAddr) {
        this.courseAddr = courseAddr;
    }

    @Override
    public String toString() {
        return "CourseBean{" +
                "courseName='" + courseName + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courserTeacher='" + courserTeacher + '\'' +
                ", courseAdd='" + courseAddr + '\'' +
                '}';
    }
}
