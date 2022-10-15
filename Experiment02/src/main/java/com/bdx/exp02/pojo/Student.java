package com.bdx.exp02.pojo;

public class Student {

    private int st_id;
    private int st_num;
    private String name;
    private String college;
    private String st_time;

    public Student() {
    }

    public Student(int st_id, int st_num, String name, String college, String st_time) {
        this.st_id = st_id;
        this.st_num = st_num;
        this.name = name;
        this.college = college;
        this.st_time = st_time;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public int getSt_num() {
        return st_num;
    }

    public void setSt_num(int st_num) {
        this.st_num = st_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Student{" +
                "st_id=" + st_id +
                ", st_num=" + st_num +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", st_time='" + st_time + '\'' +
                '}';
    }
}
