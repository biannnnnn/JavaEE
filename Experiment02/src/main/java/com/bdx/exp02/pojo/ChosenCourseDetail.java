package com.bdx.exp02.pojo;

public class ChosenCourseDetail {

    private int list_id;
    private int sele_id;
    private int cour_id;
    private int cour_num;
    private String course;
    private int period;

    public ChosenCourseDetail() {
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public int getSele_id() {
        return sele_id;
    }

    public void setSele_id(int sele_id) {
        this.sele_id = sele_id;
    }

    public int getCour_id() {
        return cour_id;
    }

    public void setCour_id(int cour_id) {
        this.cour_id = cour_id;
    }

    public int getCour_num() {
        return cour_num;
    }

    public void setCour_num(int cour_num) {
        this.cour_num = cour_num;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String cour_name) {
        this.course = cour_name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ChosenCourseDetail{" +
                "list_id=" + list_id +
                ", sele_id=" + sele_id +
                ", cour_id=" + cour_id +
                ", cour_num=" + cour_num +
                ", cour_name='" + course + '\'' +
                ", period=" + period +
                '}';
    }
}
