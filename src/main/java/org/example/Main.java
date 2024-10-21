package org.example;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Animal dog = new Dog("Шарик");
        Bowl bowl = new Bowl();
        cat.run(80);
        dog.run(28);
        dog.swim(50);
        cat.swim(2);
        cat.eat(15, bowl);
        Cat cats[] = {new Cat("Пушок"), new Cat("Рыжик"), new Cat("Беляш")};
        bowl.fill(45);
        for (int i = 0; i < cats.length; ++i) {
            cats[i].eat(16, bowl);
        }

        Animal.printCounts();

        Shape shapes[] = {new Triangle(3, 4, 5), new Circle(8), new Rectangle(8, 4)};
        for (int i = 0; i < shapes.length; ++i) {
            System.out.println("Фигура " + i + ": площадь " + shapes[i].square() + ", периметр " + shapes[i].perimeter() +
                    ", цвет границы " + shapes[i].borderColor() + ", цвет заливки " + shapes[i].fillingColor());
        }
    }
}