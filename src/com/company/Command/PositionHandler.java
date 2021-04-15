package com.company.Command;

import com.company.Singleton.Maze;

public class PositionHandler {

    Maze m;

    public PositionHandler(Maze m) {
        this.m = m;
    }

    // RECEIVER ---> MAZE

    public void occupyPosition(Position position) {
        position.execute(m);
    }

}
