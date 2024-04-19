package com.pacman;

public class GameModel {
    private GameState gameState = new NormalGameState();
    private int score = 0;
    private int lives = 2;
    private final Maze maze;
    private final Pacman pacman;
    private final ArrayList<Ghost> ghosts;

    public GameModel(int width, int height, int blockSize) {
        this.maze = new Maze(width, height, blockSize);
        this.pacman = new Pacman(blockSize / 2, blockSize / 2, Direction.RIGHT, this.maze, blockSize);
        this.ghosts = new ArrayList<>();

        initializeGameEntities();
    }

    private void initializeGameEntities() {
        maze.initialize();
        // Initialiser spøgelser
    }
    public Maze getMaze() {
        return this.maze;
    }
}

class Maze {
    private final Cell[][] cells;

    public Maze(int width, int height, int blockSize) {
        int columns = width / blockSize;
        int rows = height / blockSize;
        this.cells = new Cell[columns][rows];
    }

    public void initialize() {
        // Fylder labyrinten med vægge og celler og piller
        for (int x = 0; x < cells.length; x++) {
