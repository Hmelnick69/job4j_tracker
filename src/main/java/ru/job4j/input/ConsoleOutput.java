package ru.job4j.input;

import ru.job4j.output.Output;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}