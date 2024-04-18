package com.pacman;

interface GameState {
    void update(double dt);
    void onPacmanGhostCollision(Ghost ghost);
}
