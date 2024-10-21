package org.example;

public interface Shape {
    public double square();
    public double perimeter();
    default public String borderColor() {
        return "blue";
    }
    default public String fillingColor() {
        return "red";
    }
}
