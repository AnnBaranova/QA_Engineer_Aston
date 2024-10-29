package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "1", "2"},
                {"2", "4", "1", "2"},
                {"8", "2", "h", "5"},
                {"9", "5", "6", "5"},
        };
        try {
            System.out.println("Сумма массива = " + sumArray(array));
        }
        catch (MyArraySizeException e) {
            System.out.println("Ошибка размера");
        }
        catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
    }
    public static int sumArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("sumArray");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Значение в ячейке (" + i + ", " + j + ") не является числом");
                }
            }
        }
        return sum;
    }
}