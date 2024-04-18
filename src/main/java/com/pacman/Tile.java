package com.pacman;

import javafx.scene.image.Image;

public class Tile implements Cell {
    private Pill pill;

    public Tile(Pill pill) {
        this.pill = pill;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

/*     @Override
    public Image getImage() {
        return new Image(getClass().getResourceAsStream("/tile.png"));
    } */

    @Override
    public void render(CellVisitor visitor, int x, int y) {
        visitor.renderCell(this, x, y);
    }

    public boolean hasPill() {
        return pill != null;
    }

    public void eatPill() {
        this.pill.eatPill();
        this.pill = null;
    }

    public Pill getPill() {
        return this.pill;
    }
}
