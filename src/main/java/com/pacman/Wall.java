package com.pacman;

public class Wall implements Cell {
    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public void accept(CellVisitor visitor, int x, int y) {
        visitor.renderCell(this, x, y);
    }
}
