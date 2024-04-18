package com.pacman;

import javafx.scene.image.Image;

public class BigPill implements Pill {
    @Override
    public void eatPill() {
        System.out.println("Big pill eaten");
        // TODO: Use observer pattern to push event to GameModel
    }

    @Override
    public void render(CellVisitor cellVisitor, int x, int y) {
        cellVisitor.renderPill(this, x, y);
    }

/*     @Override
    public Image getImage() {
        return new Image(getClass().getResourceAsStream("/bigPill.png"));
    } */

}
