package ru.job4j.queue;

import java.util.*;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 0; i < count - 1; i++) {
            queue.poll();
        }
        Customer customer = queue.peek();
        return customer.name();
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        Customer customer = queue.peek();
        return customer.name();
    }
}