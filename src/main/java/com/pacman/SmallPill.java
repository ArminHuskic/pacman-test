package com.pacman;

public class SmallPill implements Pill {
    @Override
    public void eatPill() {
        System.out.println("Small pill eaten");
        // TODO: Use observer pattern to push event to GameModel
    }
}
