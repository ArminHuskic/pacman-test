package com.pacman;

public interface CellVisitor {
    void renderCell(Wall wall, int x, int y);
    void renderCell(Tile tile, int x, int y);
}
