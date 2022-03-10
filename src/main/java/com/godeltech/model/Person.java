package com.godeltech.model;

import com.godeltech.annotation.InjectRandomValue;

public class Person {
    @InjectRandomValue
    private String name;
    @InjectRandomValue
    private Boolean isMarriage;
    @InjectRandomValue
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMarriage() {
        return isMarriage;
    }

    public void setMarriage(Boolean marriage) {
        isMarriage = marriage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
