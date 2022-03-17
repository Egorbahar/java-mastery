package com.godeltech.l3pt3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Person {
    private final String name;
    private final String email;
    private final String position;
    private final int age;
}
