package com.pacman;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

// REVIEW: Should GameView extend Group or just contain a member called root
public class GameView extends Group {
    private final GameModel gameModel;
    Renderer renderer;

    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;

        Canvas canvas = new Canvas(gameModel.getWidth(), gameModel.getHeight());
        getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        renderer = new Renderer(gc);

        new AnimationTimer() {
            private long lastNanoTime = System.nanoTime();

            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, gameModel.getWidth(), gameModel.getHeight());

                double dt = (currentNanoTime - lastNanoTime) / 1000000000.0; // Seconds
                lastNanoTime = currentNanoTime;
                renderGame();

                gameModel.update(dt);
            }
        }.start();
        }
    
    private void renderGame() {
        renderMaze();
        renderPacman();
    }
    
    private void renderMaze() {
        int blockSize = this.gameModel.getBlockSize();
        Cell[][] maze = this.gameModel.getMaze();

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze.length; y++) {
                maze[x][y].accept(this.renderer, x*blockSize, y*blockSize);
            }
        }
    }

    private void renderPacman() {
        this.renderer.renderCharacter(this.gameModel.getPacman());
    }
}
