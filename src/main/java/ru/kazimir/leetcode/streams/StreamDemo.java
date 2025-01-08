package ru.kazimir.leetcode.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        // Print 11 even numbers starting from 2
        Stream.iterate(2, n -> n+1).filter(n -> n % 2 == 0).limit(11).forEach(n -> System.out.print(n + " "));
        System.out.println();
        //Create 1000 users
        List<User> users = new ArrayList<>(1000);
        Random rnd = new Random();
        for (int i = 1; i <= 1000; i++) {
            users.add(new User(
                    i,
                    i * rnd.nextInt(1000),
                    "user " + i,
                    rnd.nextInt(120),
                    rnd.nextInt(10) % 2 == 1 ? Sex.FEMALE : Sex.MALE
            ));
        }
        //Check whether all users are above 18 y.o.
        System.out.println("All users are above 18 y.o : " + users.stream().allMatch(n -> n.getAge() >= 18));
        // print 5-th collection element or null
        System.out.println("5-th element is: " + users.stream().skip(4).findFirst().orElse(null));
        //Print 7 oldest users
        System.out.println("The oldest 7 are: ");
        users.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).limit(7).forEach(System.out::println);
        //Count all users that are ready to work: males 18-65, females 18-60
        System.out.println("Ready to work " + users.stream().filter(n ->
                n.getAge() >= 18 && (n.getSex() == Sex.MALE && n.getAge() <= 65
                        || n.getSex() == Sex.FEMALE && n.getAge() <= 60)).count() + " users");
        //Print average males' age
        System.out.println("Average males's age = " +
                users.stream().filter(user -> user.getSex() == Sex.MALE).mapToInt(User::getAge).average().orElse(0));
        //Find all unique females aged above 28, set Winner to true and print their name-phone
        System.out.println("Unique female winners older then 28");
        users.stream().filter(user -> user.getSex().equals(Sex.FEMALE) && user.getAge() > 28).distinct().forEach(user -> {user.setWinner(true);
            System.out.println(user.getName() + " - " + user.getPhone());});
    }
}
