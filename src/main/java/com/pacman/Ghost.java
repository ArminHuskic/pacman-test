package com.pacman;

import javafx.scene.image.Image;

public class Ghost extends Character {
    private GhostState ghostState = new NormalGhostState();

    public Ghost(double x, double y, Direction direction, Cell[][] maze, int blockSize) {
        super(x, y, direction, maze, blockSize);
    }

    public void updateTarget() {
        // TODO: Gets new direction. Method should be called whenever pacman changes tile
        this.ghostState.target();
    }

    @Override
    public Image getImage() {
        return this.ghostState.getImage();
    }
}
