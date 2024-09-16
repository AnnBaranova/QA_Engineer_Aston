package org.example;

public class Main {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 3;
        int b = 5;
        int sum = a + b;
        if (sum >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 19;
        if (value <= 0)
            System.out.println ("Красный");
        else if (value <= 100)
            System.out.println ("Желтый");
        else
            System.out.println ("Зеленый");
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 3;
        if (a >= b)
            System.out.println ("a >= b");
        else
            System.out.println ("a < b");
    }

    public static boolean isSumBtw10and20(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20)
            return true;
        else
            return false;
    }

    public static void printSign(int d) {
        if (d < 0)
            System.out.println ("Число отрицательное");
        else
            System.out.println ("Число положительное");
    }

    public static boolean isNegative(int d) {
        if (d < 0)
            return true;
        else
            return false;
    }

    public static void nString(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeap(int y) {
        if (y % 400 == 0)
            return true;
        else if (y % 100 == 0)
            return false;
        else if (y % 4 == 0)
            return true;
        return false;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void replaceArray01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else if (array[i] == 1)
                array[i] = 0;
        }
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void less6x2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
    }

    public static void print2dArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public static void fillDiags(int[][] array) {
        for (int i = 0; i < array.length; i++) {
           array[i][i] = 1;
           array[i][array.length - i - 1] = 1;
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = initialValue;
        return array;
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.printf("isSumBtw10and20 = %b\n", isSumBtw10and20(30,6));
        printSign(-3);
        System.out.printf("isNegative = %b\n", isNegative(-7));
        nString("Java", 3);
        System.out.printf("isLeap = %b\n", isLeap(1983));

        int[] a10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(a10);
        replaceArray01(a10);
        printArray(a10);

        int[] a11 = new int[100];
        fillArray(a11);
        printArray(a11);

        int[] a12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(a12);
        less6x2(a12);
        printArray(a12);

        int[][] a13 = new int[5][5];
        fillDiags(a13);
        print2dArray(a13);

        printArray(createArray(5, 10));
    }
}