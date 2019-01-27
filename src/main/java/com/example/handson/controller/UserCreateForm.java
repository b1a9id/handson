package com.example.handson.controller;

import java.io.Serializable;
import java.net.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.handson.entity.User.Gender;

public class UserCreateForm implements Serializable {
    @NotBlank
    private String name;

    private Integer age;

    @NotNull
    private Gender gender;

    private URL imageUrl;

    private String hobby;

    private String speciality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
