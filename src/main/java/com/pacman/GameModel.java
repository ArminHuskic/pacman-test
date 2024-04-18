package com.pacman;

import java.util.ArrayList;

public class GameModel {
    private static final int SMALL_PILL_POINTS = 1;
    private static final int BIG_PILL_POINTS = 10;

    private GameState gameState = new NormalGameState();
    private int score = 0;
    private int lives = 2;
    // Maybe separate into another class
    private final Cell[][] maze;
    private final Pacman pacman;
    private final ArrayList<Ghost> ghosts;

    private int width, height, blockSize;

    public GameModel(int width, int height, int blockSize) {
        this.width = width;
        this.height = height;
        this.blockSize = blockSize;

        int columns = width/blockSize;
        int rows = height/blockSize;
        this.maze = new Cell[columns][rows];
        this.pacman = new Pacman(this.blockSize/2, this.blockSize/2, Direction.RIGHT, this.maze, blockSize);
        this.ghosts = new ArrayList<Ghost>();

        // Temporary test map
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                this.maze[x][y] = new Tile(new SmallPill());
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

        this.maze[3][5] = new Tile(new BigPill());
    }

    public void changeState(GameState state) {
        this.gameState = state;
    }

    public void update(double dt) {
        this.gameState.update(dt);

        this.pacman.update(dt);
        for (Ghost ghost : this.ghosts) {
            ghost.update(dt);

            if (this.pacman.collides(ghost)) {
                this.gameState.onPacmanGhostCollision(ghost);
            }
        }
    }

    public void onSmallPillEaten() {
        this.score += SMALL_PILL_POINTS;
    }

    public void onBigPillEaten() {
        this.score += BIG_PILL_POINTS;

        PowerGameState newState = new PowerGameState();
        newState.setGameModel(this);
        this.changeState(newState);
    }

    public void changePacmanDirection(Direction direction) {
        this.pacman.changeDirection(direction);
    }

    public void addScore(int addend) {
        this.score += addend;
    }

    public int getLives() {
        return this.lives;
    }

    public void decrementLives() {
        this.lives--;
    }

    public Cell[][] getMaze() {
        return this.maze;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    public void removeGhost(Ghost ghost) {
        this.ghosts.remove(ghost);
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
}