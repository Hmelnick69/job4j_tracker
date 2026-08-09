package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Wolf akela = new Wolf();
        Fox alisa = new Fox();
        Hare bunny = new Hare();
        Ball kolobok = new Ball();
        bunny.tryEat(kolobok);
        akela.tryEat(kolobok);
        alisa.tryEat(kolobok);
    }
}
