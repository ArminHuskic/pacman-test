package com.pacman;

public class PowerGameState implements GameState {
    private static final double DURATION = 5;

    private GameModel gameModel;
    private double timer = DURATION;

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void update(double dt) {
        this.timer -= dt;

        if (this.timer <= 0) {
            NormalGameState newState = new NormalGameState();
            newState.setGameModel(this.gameModel);
            this.gameModel.changeState(newState);
        }
    }

    @Override
    public void onPacmanGhostCollision(Ghost ghost) {
        this.gameModel.removeGhost(ghost);
    }
}