package com.pacman;

import javafx.scene.image.Image;

public class Pacman extends Character {
    public Pacman(double x, double y, Direction direction, Cell[][] maze, int blockSize) {
        super(x, y, direction, maze, blockSize);
    }

    @Override
    public Image getImage() {
        return new Image(getClass().getResourceAsStream("/pacman.png"));
    }
}
