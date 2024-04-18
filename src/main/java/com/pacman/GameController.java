package com.pacman;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameController {
    private final GameModel gameModel;
    private final GameView gameView;

    public GameController(Stage stage, int width, int height, int blockSize) {
        // REVIEW: Should all this just be moved into App.start?
        this.gameModel = new GameModel(width, height, blockSize);
        this.gameView = new GameView(this.gameModel);

        stage.setTitle("Pacman");

        Scene scene = new Scene(this.gameView.getRoot());
        stage.setScene(scene);

        // TODO: Refactor?
        scene.setOnKeyPressed(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    switch (e.getCode()) {
                        case W:
                            gameModel.changePacmanDirection(Direction.UP);
                            break;
                        case A:
                            gameModel.changePacmanDirection(Direction.LEFT);
                            break;
                        case S:
                            gameModel.changePacmanDirection(Direction.DOWN);
                            break;
                        case D:
                            gameModel.changePacmanDirection(Direction.RIGHT);
                            break;
                    }
                }
            }
        );
    }
}
