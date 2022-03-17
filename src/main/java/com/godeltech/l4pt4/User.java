package com.godeltech.l4pt4;

import java.util.List;

public class User {

    private String name;
    private Integer age;
    private List<String> emails;

    public User(String name, Integer age, List<String> emails) {
        this.name = name;
        this.age = age;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getEmails() {
        return emails;
    }
}
