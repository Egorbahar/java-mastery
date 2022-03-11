package com.godeltech.model;

import com.godeltech.annotation.InjectRandomValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    @InjectRandomValue
    private String name;
    @InjectRandomValue
    private Boolean isMarriage;
    @InjectRandomValue
    private Integer age;
}
