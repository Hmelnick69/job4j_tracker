package ru.job4j.cast;

public class Bus implements  Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по шоссе");
    }

    @Override
    public boolean canFly() {
        return false;
    }
}
