package ru.job4j.ex;

public class UserNotFoundException extends ElementNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}