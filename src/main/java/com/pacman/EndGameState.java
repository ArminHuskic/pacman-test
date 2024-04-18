package com.pacman;

public class EndGameState implements GameState {
    private GameModel gameModel;

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void onPacmanGhostCollision(Ghost ghost) {
    }
}