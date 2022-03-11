package com.godeltech;

import com.godeltech.collection.CustomCollection;
import com.godeltech.collection.MyCustomCollection;
import com.godeltech.model.Person;
import com.godeltech.processor.InjectRandomValueAnnotationProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            InjectRandomValueAnnotationProcessor injectRandomValueAnnotationProcessor = new InjectRandomValueAnnotationProcessor();
            injectRandomValueAnnotationProcessor.process(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(person.getName());
        System.out.println(person.getIsMarriage());
        System.out.println(person.getAge());
        CustomCollection<Integer> collection = new MyCustomCollection<>();
        for(int i = 0; i <500 ; i++ )
        {
            collection.add(i);
        }
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println("Contain " + collection.contains(50));
        for (Integer integer : collection) {
            System.out.println(integer);
        }

    }
}
