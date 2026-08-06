package ru.job4j.oop;

public class DummyDic {
    public static String engToRus(String eng) {
        String rusText = "Неизвестное слово. ";
        return rusText + eng;
    }

    public static void main(String[] args) {
        System.out.println(DummyDic.engToRus("Hello"));
    }
}
