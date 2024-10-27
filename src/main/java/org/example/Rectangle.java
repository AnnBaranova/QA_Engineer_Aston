package org.example;

public class Rectangle implements Shape {
    private int a;
    private int b;
    public Rectangle(int a, int b) {
        if (!(a > 0 && b > 0)) {
            System.out.println("Прямоугольник не существует");
            return;
        }
        this.a = a;
        this.b = b;
    }
    public double square() {
        return a * b;
    }
    public double perimeter() {
        return (a + b) * 2;
    }
    public String borderColor() {
        return "black";
    }
    public String fillingColor() {
        return "orange";
    }
}
