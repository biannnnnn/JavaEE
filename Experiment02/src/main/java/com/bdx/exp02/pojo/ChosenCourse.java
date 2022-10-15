package com.bdx.exp02.pojo;

import java.util.List;

public class ChosenCourse {

    private int sele_id;
    private int st_id;
    private String semester;
    private int year;
    private int st_num;
    private String name;
    private int cour_cout;
    private int cour_score_num;
    private int period_num;
    private int sele_num;
    private int req_num;

    public ChosenCourse() {
    }

    public int getSele_id() {
        return sele_id;
    }

    public void setSele_id(int id) {
        this.sele_id = id;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getCour_cout() {
        return cour_cout;
    }

    public void setCour_num(int cour_num) {
        this.cour_cout = cour_num;
    }

    public int getCour_score_num() {
        return cour_score_num;
    }

    public void setCour_score_num(int cour_score_num) {
        this.cour_score_num = cour_score_num;
    }

    public int getPeriod_num() {
        return period_num;
    }

    public void setPeriod_num(int period_num) {
        this.period_num = period_num;
    }

    public int getSele_num() {
        return sele_num;
    }

    public void setSele_num(int sele_num) {
        this.sele_num = sele_num;
    }

    public int getReq_num() {
        return req_num;
    }

    public void setReq_num(int req_num) {
        this.req_num = req_num;
    }

    public void setCour_cout(int cour_cout) {
        this.cour_cout = cour_cout;
    }

    @Override
    public String toString() {
        return "ChosenCourse{" +
                "id=" + sele_id +
                ", st_id=" + st_id +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", st_num=" + st_num +
                ", name='" + name + '\'' +
                ", cour_num=" + cour_cout +
                ", cour_score_num=" + cour_score_num +
                ", period_num=" + period_num +
                ", sele_num=" + sele_num +
                ", req_num=" + req_num +
                '}';
    }
}
