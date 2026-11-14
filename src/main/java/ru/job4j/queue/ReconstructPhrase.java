package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder firstBuilder = new StringBuilder();
        int queueSize = evenElements.size();
        for (int i = 0; i < queueSize; i++) {
            var element = evenElements.poll();
            if (i % 2 == 0) {
                firstBuilder.append(element);
            }
        }
        return firstBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder secondBuilder = new StringBuilder();
        int queueSize = descendingElements.size();
        for (int i = 0; i < queueSize; i++) {
            var element = descendingElements.pollLast();
                secondBuilder.append(element);
        }
        return secondBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}