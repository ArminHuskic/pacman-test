package com.pacman;

import java.util.ArrayList;

public class GameModel {
/*     private GameState gameState; */
    private int score = 0;
    private int lives = 3;
    // Maybe separate into another class
    private final Cell[][] maze;
    private final Character pacman = new Character(0, 0, Direction.RIGHT);
/*     private final ArrayList<Ghost> ghosts; */

    private int width, height, blockSize;

    public GameModel(int width, int height, int blockSize) {
        this.width = width;
        this.height = height;
        this.blockSize = blockSize;

        int columns = width/blockSize;
        int rows = height/blockSize;
        this.maze = new Cell[columns][rows];

        // Temporary test map
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                this.maze[x][y] = new Tile(null);
            }
        }

        for (int y = 0; y < 10; y++) {
            this.maze[5][y] = new Wall();
        }

        for (int x = 0; x < 5; x++) {
            if (x != 2 && x != 4) {
                this.maze[x][1] = new Wall();
            }
        }
    }

    public void update(double dt) {
        checkStuck(this.pacman);
        this.pacman.update(dt);
/*         this.ghosts.forEach((ghost) -> ghost.update(dt)); */
    }

    public void changePacmanDirection(Direction direction) {
        // TODO: Refactor
        boolean legal = false;
        int x = this.pacman.getCellX(this.blockSize);
        int y = this.pacman.getCellY(this.blockSize);
        int blocks = this.maze.length - 1;

        switch (direction) {
            case UP:
                if (this.maze[x][Math.max(0, y - 1)].isPassable()) {
                    legal = true;
                }
                break;
            case LEFT:
                if (this.maze[Math.max(0, x - 1)][y].isPassable()) {
                    legal = true;
                }
                break;
            case RIGHT:
                if (this.maze[Math.min(blocks, x + 1)][y].isPassable()) {
                    legal = true;
                }
                break;
            case DOWN:
                if (this.maze[x][Math.min(blocks, y + 1)].isPassable()) {
                    legal = true;
                }
                break;
        }

        if (legal) {
            this.pacman.setDirection(direction);
        }
    }

    public Cell[][] getMaze() {
        return this.maze;
    }

    public Character getPacman() {
        return this.pacman;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    private void checkStuck(Character character) {
        // TODO: Bad code, refactor later
        boolean stuck = false;
        int i = character.getCellX(this.blockSize);
        int j = character.getCellY(this.blockSize);
        int blocks = this.maze.length - 1;

        switch (character.getDirection()) {
            case UP:
                if (!this.maze[i][Math.max(0, j - 1)].isPassable()) {
                    stuck = true;
                }
                break;
            case LEFT:
                if (!this.maze[Math.max(0, i - 1)][j].isPassable()) {
                    stuck = true;
                }
                break;
            case RIGHT:
                if (!this.maze[Math.min(blocks, i + 1)][j].isPassable()) {
                    stuck = true;
                }
                break;
            case DOWN:
                if (!this.maze[i][Math.min(blocks, j + 1)].isPassable()) {
                    stuck = true;
                }
                break;
        }

        if (stuck) {
            character.setStuck();
        } else {
            character.unStuck();
        }
    }
}