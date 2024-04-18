package com.pacman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Renderer implements CellVisitor {
    private final Image WALL_IMG = new Image(getClass().getResourceAsStream("/wall.png"));
    private final Image TILE_IMG = new Image(getClass().getResourceAsStream("/tile.png"));
    private final Image SMALL_PILL_IMG = new Image(getClass().getResourceAsStream("/smallPill.png"));
    private final Image BIG_PILL_IMG = new Image(getClass().getResourceAsStream("/bigPill.png"));

    private GameModel gameModel;
    private GraphicsContext gc;

    public Renderer(GameModel gameModel, GraphicsContext gc) {
        this.gameModel = gameModel;
        this.gc = gc;
    }

    @Override
    public void renderCell(Wall wall, int x, int y) {
        this.gc.drawImage(WALL_IMG, x, y);
    }

    @Override
    public void renderCell(Tile tile, int x, int y) {
        this.gc.drawImage(TILE_IMG, x, y);

        if (tile.hasPill()) {
            Pill pill = tile.getPill();
            pill.render(this, x, y);
        }
    }

    @Override
    public void renderPill(SmallPill pill, int x, int y) {
        this.gc.drawImage(SMALL_PILL_IMG, x, y);
    }

    @Override
    public void renderPill(BigPill pill, int x, int y) {
        this.gc.drawImage(BIG_PILL_IMG, x, y);
    }

    public void renderGame() {
        this.gc.clearRect(0, 0, gameModel.getWidth(), gameModel.getHeight());
        renderMaze();
        renderCharacters();
    }
    
    private void renderMaze() {
        int blockSize = this.gameModel.getBlockSize();
        Cell[][] maze = this.gameModel.getMaze();

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze.length; y++) {
                maze[x][y].render(this, x*blockSize, y*blockSize);
            }
        }
    }

    private void renderCharacters() {
        renderCharacter(this.gameModel.getPacman());

        for (Ghost ghost : this.gameModel.getGhosts()) {
            renderCharacter(ghost);
        }
    }

    private void renderCharacter(Character character) {
        Image img = character.getImage();

        // DrawImage draws at upper left corner
        int upperLeftOffset = this.gameModel.getBlockSize()/2;
        this.gc.drawImage(img, character.getX() - upperLeftOffset, character.getY() - upperLeftOffset);
    }
}
