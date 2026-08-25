package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по железной дороге");
    }

    @Override
    public boolean canFly() {
        return false;
    }
}
