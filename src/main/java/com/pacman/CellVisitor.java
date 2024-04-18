package com.pacman;

public interface CellVisitor {
    void renderCell(Wall wall, int x, int y);
    void renderCell(Tile tile, int x, int y);
    // Should we make a separate visitor for Pill?
    void renderPill(SmallPill pill, int x, int y);
    void renderPill(BigPill pill, int x, int y);
}
