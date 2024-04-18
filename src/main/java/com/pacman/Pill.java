package com.pacman;

interface Pill {
    void eatPill();
    void render(CellVisitor cellVisitor, int x, int y);
}
