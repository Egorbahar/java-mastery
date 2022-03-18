package com.godeltech.l4pt4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;
    private List<String> emails;

}
