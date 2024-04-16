package com.pacman;

public class Tile implements Cell {
    private Pill pill;

    public Tile(Pill pill) {
        this.pill = pill;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void accept(CellVisitor visitor, int x, int y) {
        visitor.renderCell(this, x, y);
    }

    public boolean hasPill() {
        return pill != null;
    }

    public void eatPill() {
        this.pill.eatPill();
        this.pill = null;
    }

    // Getter is necessary for GameView to draw pills
    public Pill getPill() {
        return this.pill;
    }
}
