package com.bdx.exp02.pojo;

public class ChosenCourseStudent extends ChosenCourse {

    private String college;
    private String st_time;

    public ChosenCourseStudent() {
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSt_time() {
        return st_time;
    }

    public void setSt_time(String st_time) {
        this.st_time = st_time;
    }

    @Override
    public String toString() {
        return "ChosenCourseStudent{" +
                "college='" + college + '\'' +
                ", st_time='" + st_time + '\'' +
                '}';
    }
}
