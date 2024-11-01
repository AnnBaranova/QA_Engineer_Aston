package org.example;

import java.util.*;

public class Main {
    public static void task1() {
        ArrayList<String> animal = new ArrayList<>(20);
        animal.add("lion");
        animal.add("sheep");
        animal.add("tiger");
        animal.add("giraffe");
        animal.add("elephant");
        animal.add("zebra");
        animal.add("monkey");
        animal.add("cougar");
        animal.add("leopard");
        animal.add("cheetah");
        animal.add("snake");
        animal.add("sloth");
        animal.add("cow");
        animal.add("monkey");
        animal.add("cougar");
        animal.add("leopard");
        animal.add("cheetah");
        animal.add("sloth");
        animal.add("sloth");
        animal.add("cow");

        HashSet<String> hashSet = new HashSet<>(animal);
        System.out.println(hashSet);

        HashMap<String, Integer> counts = new HashMap<>();
        for (String s: animal) {
            if (counts.containsKey(s)) {
                Integer x = counts.get(s);
                x += 1;
                counts.put(s, x);
            }
            else {
                counts.put(s, 1);
            }
        }
        System.out.println(counts);
    }
    public static void task2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Dromov", "+712345546");
        phoneBook.add("Dromov", "+768894666");
        phoneBook.add("Dromov", "+788962256");
        phoneBook.add("Bir", "+738882246");
        phoneBook.add("Ivanov", "+712346746");
        phoneBook.add("Petrov", "+716845546");
        phoneBook.add("Sidorov", "+712345996");
        System.out.println("Номера Дромова:" + phoneBook.get("Dromov"));
        System.out.println("Номера Бира:" + phoneBook.get("Bir"));
    }

    public static void main(String[] args) {
        task1();
        task2();
    }
}