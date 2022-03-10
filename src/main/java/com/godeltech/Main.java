package com.godeltech;

import com.godeltech.model.Person;
import com.godeltech.processor.InjectRandomValueAnnotationProcessor;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        try {
           InjectRandomValueAnnotationProcessor injectRandomValueAnnotationProcessor = new  InjectRandomValueAnnotationProcessor();
           injectRandomValueAnnotationProcessor.process(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(person.getName());
        System.out.println(person.getMarriage());
        System.out.println(person.getAge());
    }
}
