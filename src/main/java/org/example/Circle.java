package org.example;

public class Circle implements Shape {
    private int r;
    public Circle(int r) {
        if (r <= 0) {
            System.out.println("Круг не существует");
            return;
        }
        this.r = r;
    }
    public double square() {
        return Math.PI * Math.pow(r, 2);
    }
    public double perimeter() {
        return 2 * Math.PI * r;
    }
    public String borderColor() {
        return "black";
    }
}
