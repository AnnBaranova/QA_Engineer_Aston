package org.example;

public class Animal {
    private static int cats;
    private static int dogs;
    private static int others;

    public static void printCounts() {
        System.out.println("Котов: " + cats + ", собак: " + dogs + ", остальных: " + others + ", всего: " + (cats + dogs + others));
    }

    protected String name;
    protected Animal(String name) {
        this.name = name;
        if (this instanceof Cat)
            ++cats;
        else if (this instanceof Dog)
            ++dogs;
        else
            ++others;
    }
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м");
    }
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м");
    }
}
