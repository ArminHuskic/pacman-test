package com.pacman;

public interface Cell {
    boolean isPassable();
    void accept(CellVisitor visitor, int x, int y);
}
