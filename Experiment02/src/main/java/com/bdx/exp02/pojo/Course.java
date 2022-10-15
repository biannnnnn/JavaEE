package com.bdx.exp02.pojo;

public class Course {

    private int cour_id;
    private int cour_num;
    private String course;
    private String nature;
    private String semester;
    private int period;
    private int cour_score;

    public Course() {
    }

    public Course(int cour_id, int cour_num, String course, String nature, String semester, int period, int cour_score) {
        this.cour_id = cour_id;
        this.cour_num = cour_num;
        this.course = course;
        this.nature = nature;
        this.semester = semester;
        this.period = period;
        this.cour_score = cour_score;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCour_score() {
        return cour_score;
    }

    public void setCour_score(int cour_score) {
        this.cour_score = cour_score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cour_id=" + cour_id +
                ", cour_num=" + cour_num +
                ", course='" + course + '\'' +
                ", nature='" + nature + '\'' +
                ", semester='" + semester + '\'' +
                ", period=" + period +
                ", cour_score=" + cour_score +
                '}';
    }
}
