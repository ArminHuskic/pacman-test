package com.pacman;

public abstract class Character implements Renderable {
    private static final int DEFAULT_SPEED = 100;

    protected double x, y;
/*     private double lastX, lastY; */
    protected double speed = DEFAULT_SPEED;
    protected Direction direction;
    private final Cell[][] maze;
    protected int blockSize;

    public Character(double x, double y, Direction direction, Cell[][] maze, int blockSize) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maze = maze;
        this.blockSize = blockSize;
    }

    public void update(double dt) {
        if (isStuck()) {
            return;
        }

/*         this.lastX = this.x;
        this.lastY = this.y; */

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

    private boolean isStuck() {
        // TODO: Bad code, refactor later
        boolean stuck = false;
        int i = getCellX();
        int j = getCellY();
        int blocks = this.maze.length - 1;

        switch (getDirection()) {
            case UP:
                if (!this.maze[i][Math.max(0, j - 1)].isPassable() && (y % this.blockSize) <= this.blockSize/2) {
                    stuck = true;
                    correctY();
                }
                break;
            case LEFT:
                if (!this.maze[Math.max(0, i - 1)][j].isPassable() && (x % this.blockSize) <= this.blockSize/2) {
                    stuck = true;
                    correctX();
                }
                break;
            case RIGHT:
                if (!this.maze[Math.min(blocks, i + 1)][j].isPassable() && (x % this.blockSize) >= this.blockSize/2) {
                    stuck = true;
                    correctX();
                }
                break;
            case DOWN:
                if (!this.maze[i][Math.min(blocks, j + 1)].isPassable() && (y % this.blockSize) >= this.blockSize/2) {
                    stuck = true;
                    correctY();
                }
                break;
        }

        return stuck;
    }

    public void changeDirection(Direction direction) {
        // TODO: Bad code, refactor later
        boolean legal = false;
/*         int x = (int) getX();
        int y = (int) getY(); */
        int i = getCellX();
        int j = getCellY();
        int blocks = this.maze.length - 1;

/*         int xInBlock = (int) this.x % this.blockSize;
        int yInBlock = (int) this.y % this.blockSize;
        boolean xAligned = xInBlock == this.blockSize/2;
        boolean yAligned = yInBlock == this.blockSize/2; */

/*         int blockMid = this.blockSize/2;
        int lastXInBlock = (int) this.lastX % this.blockSize;
        int lastYInBlock = (int) this.lastY % this.blockSize;
        boolean passedMidX = (lastXInBlock <= blockMid && xInBlock >= blockMid) || (lastXInBlock >= blockMid && xInBlock <= blockMid);
        boolean passedMidY = (lastYInBlock <= blockMid && yInBlock >= blockMid) || (lastYInBlock >= blockMid && yInBlock <= blockMid); */

        switch (direction) {
            case UP:
                if (this.maze[i][Math.max(0, j - 1)].isPassable()) {
                    legal = true;
                    correctX();
                }
                break;
            case LEFT:
                if (this.maze[Math.max(0, i - 1)][j].isPassable()) {
                    legal = true;
                    correctY();
                }
                break;
            case RIGHT:
                if (this.maze[Math.min(blocks, i + 1)][j].isPassable()) {
                    legal = true;
                    correctY();
                }
                break;
            case DOWN:
                if (this.maze[i][Math.min(blocks, j + 1)].isPassable()) {
                    legal = true;
                    correctX();
                }
                break;
        }

        if (legal) {
            this.direction = direction;
        }
    }

    public boolean collides(Character other) {
        return Math.abs(this.x - other.getX()) < this.blockSize || Math.abs(this.y - other.getY()) < this.blockSize;
    }

    public void correctX() {
        this.x = roundToNearestMultiple(this.x, this.blockSize/2);
    }

    public void correctY() {
        this.y = roundToNearestMultiple(this.y, this.blockSize/2);
    }

    public int getCellX() {
        return (int) this.x/this.blockSize;
    }

    public int getCellY() {
        return (int) this.y/this.blockSize;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return this.direction;
    }

    private static double roundToNearestMultiple(double num, int multiple) {
        double remainder = num % multiple;
        if (remainder < multiple / 2.0) {
            return num - remainder;
        } else {
            return num + (multiple - remainder);
    }
}
}
