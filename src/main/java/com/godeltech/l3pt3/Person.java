package com.godeltech.l3pt3;

class Person {

    private String name;
    private String email;
    private String position;
    private int age;

    public Person(String name, String email, String position, int age) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }
}
