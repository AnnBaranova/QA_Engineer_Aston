package org.example;

public class Cat extends Animal {
    private boolean fed_up;
    public Cat(String name) {
        super(name);
        fed_up = false;
    }
    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(name + ": мы, коты, не бегаем больше 200 м");
            return;
        }
        super.run(distance);
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + ": мы, коты, не умеем плавать");
    }
    public void eat(int thing, Bowl bowl) {
        if (fed_up) {
            System.out.println(name + " уже сыт");
        }
        else if (bowl.take(thing)) {
            fed_up = true;
            System.out.println(name + " съел " + thing + " шт еды");
        }
        else
            System.out.println(name + " не поел");
    }
}
