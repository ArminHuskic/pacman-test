package com.pacman;

public interface Cell {
    boolean isPassable();
    void render(CellVisitor visitor, int x, int y);
}
