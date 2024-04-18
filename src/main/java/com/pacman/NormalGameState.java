package com.pacman;

public class NormalGameState implements GameState {
    private static final double PAUSE_DURATION = 3;

    private GameModel gameModel;
    private double pause_timer = PAUSE_DURATION;
    private boolean paused = false;

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void update(double dt) {
        if (this.paused) {
            this.pause_timer -= dt;

            if (this.pause_timer <= 0) {
                // TODO: Make characters return to their original positions
                NormalGameState newState = new NormalGameState();
                newState.setGameModel(gameModel);
                this.gameModel.changeState(newState);
            }
        }
    }

    @Override
    public void onPacmanGhostCollision(Ghost ghost) {
        this.gameModel.decrementLives();

        if (this.gameModel.getLives() <= 0) {
            EndGameState newState = new EndGameState();
            newState.setGameModel(gameModel);
            this.gameModel.changeState(newState);
        } else {
            this.paused = true;
        }
    }
}