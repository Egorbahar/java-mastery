package com.godeltech.l3pt3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Petr", "petr@godeltech.com", "developer", 24),
                new Person("Evgeniy", "evg@mail.com", "manager", 18),
                new Person("Thanos", "thanos@titanov.net", "dark lord", 5_000)
        );
        PersonProcessor processor = new PersonProcessor();
        processor.process(personList,
                new Filter() {
                    @Override
                    public boolean match(Person person) {
                        return "developer".equals(person.getPosition()) || person.getAge() > 20;
                    }
                },
                new Printer() {
                    @Override
                    public void print(Person person) {
                        System.out.println(person.getName());
                    }
                }
        );
    }
}
