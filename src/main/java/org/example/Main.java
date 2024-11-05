package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("факториал 3 = " + factorial(3));
    }
    public static int factorial(int n) {
        if (n < 0)
            return -1;

        int result = 1;

        for (; n > 0;) {
            result = result * n;
            n = n - 1;
        }
        return result;
    }
}

