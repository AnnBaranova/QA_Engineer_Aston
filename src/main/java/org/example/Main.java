package org.example;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Ivanov Ivan", "Engineer", "iivs@mailbox.com", "89059562354", 35000, 25);
        workers[1] = new Worker("Petrov Petr", "Engineer", "pptr@mailbox.com", "89051562354", 32000, 24);
        workers[2] = new Worker("Bir Roman", "Engineer", "rbir@mailbox.com", "89512562354", 38000, 32);
        workers[3] = new Worker("Smirnov Oleg", "Engineer", "osm@mailbox.com", "89051562354", 33000, 25);
        workers[4] = new Worker("Stenina Kira", "Engineer", "kirs@mailbox.com", "89231562530", 37000, 37);
        for (int i = 0; i < workers.length; i++)
            workers[i].print();
    }
}

        

