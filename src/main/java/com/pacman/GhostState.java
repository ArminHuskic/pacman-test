package com.pacman;

interface GhostState {
    void setGhost(Ghost ghost);
    void setSearchStrategy(SearchStrategy SearchStrategy);
    void target();
}
