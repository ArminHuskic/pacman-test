package com.pacman;

public class Entity {
    protected double x, y;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
