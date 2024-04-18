package com.pacman;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameView {
    private final GameModel gameModel;
    Group root;
    Renderer renderer;

    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;

        this.root = new Group();
        Canvas canvas = new Canvas(gameModel.getWidth(), gameModel.getHeight());
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        renderer = new Renderer(this.gameModel, gc);

        new AnimationTimer() {
            private long lastNanoTime = System.nanoTime();

            public void handle(long currentNanoTime) {
                double dt = (currentNanoTime - lastNanoTime) / 1000000000.0; // Seconds
                lastNanoTime = currentNanoTime;
                renderer.renderGame();

                gameModel.update(dt);
            }
        }.start();
        }
    
    public Group getRoot() {
        return root;
    }
}
