package org.example;

public class Cat extends Animal {
    private int fed;
    public Cat(String name) {
        super(name);
        fed = 0;
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
    public void eat(Bowl bowl) {
        if (fed == 10) {
            System.out.println(name + " уже сыт");
            return;
        }
        int to_eat = 10 - fed;
        if (bowl.take(to_eat)) {
            fed += to_eat;
            System.out.println(name + " наелся");
        }
        else
            System.out.println(name + " не поел");
    }
}
