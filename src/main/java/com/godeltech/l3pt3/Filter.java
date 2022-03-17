package com.godeltech.l3pt3;

@FunctionalInterface
interface Filter {
    boolean match(Person person);
}
