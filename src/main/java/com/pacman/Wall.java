package com.pacman;

import javafx.scene.image.Image;

public class Wall implements Cell {
    @Override
    public boolean isPassable() {
        return false;
    }

/*     @Override
    public Image getImage() {
        return new Image(getClass().getResourceAsStream("/wall.png"));
    } */

    @Override
    public void render(CellVisitor visitor, int x, int y) {
        visitor.renderCell(this, x, y);
    }
}
