package com.godeltech.l3pt3;

import java.util.List;

public class PersonProcessor {

    public void process(List<Person> data,
                        Filter filter,
                        Printer printer) {
        data.stream().filter(filter::match).forEach(printer::print);
    }
}
