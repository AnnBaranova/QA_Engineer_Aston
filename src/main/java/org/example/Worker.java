package org.example;

public class Worker {
    private String name;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Worker (String name, String post, String email, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void print () {
        System.out.println("Сотрудник ФИО: " + this.name);
        System.out.println("Должность: " + this.post);
        System.out.println("email: " + this.email);
        System.out.println("Телефон: " + this.phone);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
    }
}
