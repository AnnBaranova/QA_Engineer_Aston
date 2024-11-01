package org.example;

import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    private TreeMap<String, TreeSet<String>> phoneBook;
    public PhoneBook() {
        phoneBook = new TreeMap<>();
    }
    public void add(String name, String number) {
        TreeSet<String> numbers;
        if (phoneBook.containsKey(name)) {
            numbers = phoneBook.get(name);
        }
        else {
            numbers = new TreeSet<>();
            phoneBook.put(name, numbers);
        }
        numbers.add(number);
    }
    public TreeSet<String> get(String name) {
        return phoneBook.get(name);
    }
}
