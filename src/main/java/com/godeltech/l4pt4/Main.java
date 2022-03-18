package com.godeltech.l4pt4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<User> users = buildUsersCollection();

        /*
        Print name of each user
         */
        System.out.println("All users:");
        users.forEach(user -> System.out.println(user.getName()));

        /*
        Print name only if user age >= 18
         */
        System.out.println("Users with age >= 18:");
        users.stream()
                .filter(user -> user.getAge() >= 18)
                .forEach(user -> System.out.println(user.getName()));
        /*
        Print unique names
         */
        System.out.println("Unique names:");
        users.stream()
                .map(User::getName)
                .distinct()
                .forEach(System.out::println);

        /*
          Print unique emails of users
         */
        System.out.println("Unique emails:");
        users.stream()
                .map(User::getEmails)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);
        /*
          Print total age (sum) of all users
         */
        System.out.println("Total age:");
        System.out.println(users.stream()
                .mapToInt(User::getAge)
                .sum());
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
