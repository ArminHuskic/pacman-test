package com.pacman;

public class BigPill implements Pill {
    @Override
    public void eatPill() {
        System.out.println("Big pill eaten");
        // TODO: Use observer pattern to push event to GameModel
    }
}
