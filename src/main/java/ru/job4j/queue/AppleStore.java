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
        int i = 0;
        String result = "";
        for (Customer customer : queue) {
            i++;
            if (i == count) {
                result = customer.name();
                break;
            }
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        int i = 0;
        String result = "";
        for (Customer customer : queue) {
            i++;
            if (i == count + 1) {
                result = customer.name();
                break;
            }
        }
        return result;
    }
}