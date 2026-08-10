package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int m) {
        return m - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int s) {
        return Calculator.sum(s) + Calculator.minus(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}
