package com.pacman;

public class Character extends Entity {
    private static final int DEFAULT_SPEED = 100;

    protected double speed = DEFAULT_SPEED;
    protected Direction direction;
    protected boolean isStuck = false;

    public Character(double x, double y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    public int getCellX(int blockSize) {
        int x;

        if (direction == Direction.UP || direction == Direction.LEFT) {
            // Calculate cell index based on lower right
            x = (int) this.x + blockSize - 1;
        } else {
            // Upper left
            x = (int) this.x;
        }

        return x/blockSize;
    }

    public int getCellY(int blockSize) {
        int y;

        if (direction == Direction.UP || direction == Direction.LEFT) {
            y = (int) this.y + blockSize - 1;
        } else {
            y = (int) this.y;
        }

        return y/blockSize;
    }

    public void update(double dt) {
        if (isStuck) {
            return;
        }

        // Origin is upper left
        switch (direction) {
            case UP:
                this.y -= speed*dt;
                break;
            case LEFT:
                this.x -= speed*dt;
                break;
            case RIGHT:
                this.x += speed*dt;
                break;
            case DOWN:
                this.y += speed*dt;
                break;
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setStuck() {
        this.isStuck = true;
    }

    public void unStuck() {
        this.isStuck = false;
    }
}
