package com.apologizebao.bean;

/**
 * Created by apologizebao on 16-12-19.
 */
public class GradeBean {
    private String courseCode; //课程代码
    private String courseName; //课程名称
    private String coursePro;  //课程性质
    private String courseType; //课程类属
    private String fuxiu; //辅修标记
    private String credit;     //学分
    private String grade;      //期末成绩
    private String finalGrade; //最终成绩
    private String secondGrade; //补考重考成绩
    private String reLearnGrade; //重修成绩

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePro() {
        return coursePro;
    }

    public void setCoursePro(String coursePro) {
        this.coursePro = coursePro;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getFuxiu() {
        return fuxiu;
    }

    public void setFuxiu(String fuxiu) {
        this.fuxiu = fuxiu;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getSecondGrade() {
        return secondGrade;
    }

    public void setSecondGrade(String secondGrade) {
        this.secondGrade = secondGrade;
    }

    public String getReLearnGrade() {
        return reLearnGrade;
    }

    public void setReLearnGrade(String reLearnGrade) {
        this.reLearnGrade = reLearnGrade;
    }

    @Override
    public String toString() {
        return "GradeBean{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", coursePro='" + coursePro + '\'' +
                ", courseType='" + courseType + '\'' +
                ", fuxiu='" + fuxiu + '\'' +
                ", credit='" + credit + '\'' +
                ", grade='" + grade + '\'' +
                ", finalGrade='" + finalGrade + '\'' +
                ", secondGrade='" + secondGrade + '\'' +
                ", reLearnGrade='" + reLearnGrade + '\'' +
                '}';
    }
}
