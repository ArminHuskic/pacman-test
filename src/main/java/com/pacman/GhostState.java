package com.pacman;

interface GhostState extends Renderable {
    void setGhost(Ghost ghost);
    void setSearchStrategy(SearchStrategy SearchStrategy);
    void target();
}
