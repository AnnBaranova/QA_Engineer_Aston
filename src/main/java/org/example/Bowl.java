package org.example;

public class Bowl {
    private int thing;
    public void fill(int thing) {
        this.thing += thing;
    }
    public boolean take(int thing) {
        if (thing < 0) {
            System.out.println("Нельзя съесть отрицательное количество еды");
            return false;
        }
        if (thing > this.thing)
            return false;
        this.thing -= thing;
        return true;
    }
}
