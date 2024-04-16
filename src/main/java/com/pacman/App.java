package com.pacman;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int BLOCK_SIZE = 32;

    @Override
    public void start(Stage stage) {
        GameController gameController = new GameController(stage, WIDTH, HEIGHT, BLOCK_SIZE);

        // Not in GameController, as its constructor only sets up
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}