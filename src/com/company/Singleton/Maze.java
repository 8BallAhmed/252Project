package com.company.Singleton;

import java.io.File;
import java.io.RandomAccessFile;

import com.company.Iterator.MazeIterator;

public class Maze {

    private static Maze m;
    private String fields[][] = new String[10][10];
    private MazeIterator mi;

    // 4x5 <-- Parse --> [4][5] ---> Letter S // 1
    // 7x6 <-- Parse --> [7][6] ---> Letter F // 2
    // 3x2 <-- Parse --> [3][2] ---> Letter O // 3

    private Maze() {
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[x].length; y++) {
                fields[x][y] = " ";
            }
        }
        mi = new MazeIterator(fields);

    }

    public String[][] getFields() {
        return this.fields;
    }

    public void printMaze() {
        int count = 0;
        System.out.print("[");
        while (mi.hasNext()) {
            if (count == 10) {
                System.out.print("]\n[");
                count = 0;
            }
            System.out.print(mi.next());
            count++;
        }
        System.out.print("]");
    }

    public static Maze getInstance() {
        if (m == null) {
            m = new Maze();
            return m;
        } else {
            return m;
        }
    }

    public void toggleObstacle(int row, int col) {
        String fields[][] = m.getFields();
        if (fields[row][col].equalsIgnoreCase("o")) {
            fields[row][col] = " ";
        } else {
            fields[row][col] = "o";
        }
    }

}
