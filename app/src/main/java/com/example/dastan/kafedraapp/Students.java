package com.example.dastan.kafedraapp;

import java.io.Serializable;

/**
 * Created by Dastan on 29.11.2016.
 */
public class Students implements Serializable {
    public Students() {

    }


    int id;
    String course;
    String fio;
    String group;
    String photo_students;

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPhoto_students(String photo_students) {
        this.photo_students = photo_students;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getPhoto_students() {
        return photo_students;
    }
}