package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student tim = new Student();
        tim.setFullName("Ivanov Tim Petrovich");
        tim.setGroup("4B");
        tim.setStartDate(LocalDate.of(2020, 2, 9));
        System.out.println("Name: " + tim.getFullName());
        System.out.println("Group: " + tim.getGroup());
        System.out.println("Start day: " + tim.getStartDate());
    }
}
