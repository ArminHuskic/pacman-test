package com.pacman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Renderer implements CellVisitor {
    private GraphicsContext gc;

    public Renderer(GraphicsContext gc) {
        this.gc = gc;
    }

    public void renderCell(Wall wall, int x, int y) {
        Image img = new Image(getClass().getResourceAsStream("/wall.png"));
        this.gc.drawImage(img, x, y);
    }

    public void renderCell(Tile wall, int x, int y) {
        Image img = new Image(getClass().getResourceAsStream("/tile.png"));
        this.gc.drawImage(img, x, y);
    }

    public void renderCharacter(Character character) {
        // Temporary test, need to get image depending on character and their state
        Image img = new Image(getClass().getResourceAsStream("/pacman.png"));

        this.gc.drawImage(img, character.getX(), character.getY());
    }
}
