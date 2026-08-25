package ru.job4j.cast;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airbus = new Airbus();
        Vehicle train = new Train();
        Vehicle[] array = new Vehicle[]{bus, airbus, train};
        for (Vehicle object : array) {
            System.out.println("Может летать: " + object.canFly());
            object.move();
        }
    }
}
