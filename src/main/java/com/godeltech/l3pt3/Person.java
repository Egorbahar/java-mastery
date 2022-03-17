package com.godeltech.l3pt3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Person {
    private final String name;
    private final String email;
    private final String position;
    private final int age;
}
