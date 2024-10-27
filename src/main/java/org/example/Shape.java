package org.example;

public interface Shape {
    default double square() {
        throw new UnsupportedOperationException();
    }
    default double perimeter() {
        throw new UnsupportedOperationException();
    }
    public String borderColor();
    public String fillingColor();
}
