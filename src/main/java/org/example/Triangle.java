package org.example;

public class Triangle implements Shape {
    private int a;
    private int b;
    private int c;
    public Triangle(int a, int b, int c) {
        if (!(a > 0 && b > 0 && c >0 && (a + c) > b && (c + b) > a && (a + b) > c)) {
            System.out.println("Треугольник не существует");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double square() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public double perimeter() {
        return a + b + c;
    }
    public String borderColor() {
        return "blue";
    }
    public String fillingColor() {
        return "red";
    }
}
