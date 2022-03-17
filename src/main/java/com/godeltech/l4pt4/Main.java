package com.godeltech.l4pt4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = buildUsersCollection();

        /*
        Print name of each user
         */
        System.out.println("All users:");
        for (User user : users) {
            System.out.println(user.getName());
        }

        /*
        Print name only if user age >= 18
         */
        System.out.println("Users with age >= 18:");
        for (User user : users) {
            if (user.getAge() >= 18) {
                System.out.println(user.getName());
            }
        }

        /*
        Print unique names
         */
        System.out.println("Unique names:");
        Set<String> names = new HashSet<String>();
        for (User user : users) {
            names.add(user.getName());
        }
        for (String name : names) {
            System.out.println(name);
        }

        /**
         * Print unique emails of users
         */
        System.out.println("Unique emails:");
        Set<String> emails = new HashSet<String>();
        for (User user : users) {
            for (String email : user.getEmails()) {
                emails.add(email);
            }
        }
        for (String email : emails) {
            System.out.println(email);
        }

        /**
         * Print total age (sum) of all users
         */
        System.out.println("Total age:");
        Integer totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        System.out.println(totalAge);
    }

    private static List<User> buildUsersCollection() {
        return Arrays.asList(
                new User("Ivan", 14, Arrays.asList("idontliketorepeattwice@mail.ru", "idontliketorepeattwice@mail.ru", "msin@fds.com")),
                new User("John", 18, Arrays.asList("lemon@john.com", "j@weak.io", "j@weak.io", "j@weak.io")),
                new User("Maria", 23, Arrays.asList("db@maria.ru", "xray@gmail.com", "xray@gmail.com", "xray@gmail.com")),
                new User("Kate", 32, Arrays.asList("hh@tut.ru", "passwordisthesameaslogin@gmail.com")),
                new User("Phil", 12, Arrays.asList("reallycomplexmail222@hh.ru")),
                new User("Kate", 19, Arrays.asList("reallycomplexmail333@hh.ru")),
                new User("John", 22, Arrays.asList("reallycomplexmail444@hh.ru", "idontliketorepeattwice@mail.ru"))
        );
    }
}
