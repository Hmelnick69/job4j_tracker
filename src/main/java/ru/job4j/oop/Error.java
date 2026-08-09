package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Статус ошибки: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Текст ошибки: " + message);
    }

    public static void main(String[] args) {
        Error notFound = new Error(false, 404, "Not found");
        Error badGateway = new Error(true, 502, "Bad Gateway");
        notFound.printInfo();
        badGateway.printInfo();
    }
}
