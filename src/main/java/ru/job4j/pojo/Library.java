package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 500);
        Book second = new Book("Война и мир", 453);
        Book third = new Book("BABOOK", 760);
        Book fourth = new Book("Преступление и наказание", 890);
        Book[] array = new Book[4];
        array[0] = first;
        array[1] = second;
        array[2] = third;
        array[3] = fourth;
        for (int index = 0; index < array.length; index++) {
            Book book = array[index];
            System.out.println(book.getName()
                    + " - "
                    + book.getPageCount()
                    + " страниц");
        }
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        System.out.println("Перестановка индексов:");
        for (int index = 0; index < array.length; index++) {
            Book book = array[index];
            System.out.println(book.getName()
                    + " - " + book.getPageCount()
                    + " страниц");
        }
        System.out.println("Вывод с условием:");
        for (int index = 0; index < array.length; index++) {
            Book book = array[index];
            String name = book.getName();
            if (name.equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPageCount() + " страниц");
            }
        }
    }
}
