package ru.job4j.cast;

public class Airbus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Самолет летит в аэропорт");
    }

    @Override
    public boolean canFly() {
        return true;
    }
}
