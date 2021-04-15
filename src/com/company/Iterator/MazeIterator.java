package com.company.Iterator;

import java.util.Iterator;

public class MazeIterator implements Iterator {

    String maze[][];
    int indexX = 0;
    int indexY = 0;

    public MazeIterator(String maze[][]) {
        this.maze = maze;
    }

    @Override
    public boolean hasNext() {

        if (indexY == 10) {
            indexX = 0;
            indexY = 0;
            return false;
        }
        if (indexX < maze.length) {
            return true;
        }
        indexY++;
        if (indexY != maze[0].length) {
            indexX = 0;
        }

        if (indexY < maze[0].length) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return maze[indexX++][indexY];
        }
        return "";
    }
}
