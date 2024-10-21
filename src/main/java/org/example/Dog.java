package org.example;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(name + ": мы, собаки, не бегаем больше 500 м");
            return;
        }
        super.run(distance);
    }
    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + ": мы, собаки, не плаваем больше 10 м");
            return;
        }
        super.swim(distance);
    }
}
