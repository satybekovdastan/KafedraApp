package com.example.dastan.kafedraapp;

import java.io.Serializable;

/**
 * Created by Dastan on 16.06.2016.
 */
public class Vse implements Serializable {
    public Vse() {
    }

    int id;
    String fio;
    String email;
    String job_training;
    String photo_url;
    String scientific_work;
    String work_programs;
    String position;
    String title_news;
    String image_news;
    String description_news;


    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setJob_training(String job_training) {
        this.job_training = job_training;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public void setScientific_work(String scientific_work) {
        this.scientific_work = scientific_work;
    }

    public void setWork_programs(String work_programs) {
        this.work_programs = work_programs;
    }

    public String getEmail() {
        return email;
    }

    public String getFio() {
        return fio;
    }

    public String getJob_training() {
        return job_training;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public String getScientific_work() {
        return scientific_work;
    }

    public String getWork_programs() {
        return work_programs;
    }


    public void setDescription_news(String description_news) {
        this.description_news = description_news;
    }

    public void setImage_news(String image_news) {
        this.image_news = image_news;
    }

    public void setTitle_news(String title_news) {
        this.title_news = title_news;
    }

    public String getDescription_news() {
        return description_news;
    }

    public String getImage_news() {
        return image_news;
    }

    public String getTitle_news() {
        return title_news;
    }
}
