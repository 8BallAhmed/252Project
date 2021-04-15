package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.company.Command.FinishPosition;
import com.company.Command.ObstaclePosition;
import com.company.Command.PositionHandler;
import com.company.Command.StartPosition;
import com.company.Iterator.MazeIterator;
import com.company.Singleton.Maze;
import com.company.Visitor.MazeVisitor;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Maze m = Maze.getInstance();
        menu(m);

    }

    public static void menu(Maze m) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int obX;
        int obY;
        MazeVisitor mv = new MazeVisitor();
        PositionHandler ph = new PositionHandler(m);
        String menu = "Welcome to Maze Solver! Please select an option: "
                + "\n1. Select Start Position\n2. Select Finish Position\n3. Toggle Obstacle"
                + "\n4. Randomly generate 10 obstacles\n5. Calculate shortest path\n6. Print Maze\n"
                + "7. Load Maze from File\n8. Save Maze in file";
        System.out.println(menu);
        while (true) {

            System.out.print("\n\tYour choice: ");
            choice = input.nextInt();
            if (choice > 8 || choice < 0) {
                System.out.println("Wrong input! Please select a number between 0 and 9: ");
            }
            if (choice == 1) {
                ph.occupyPosition(new StartPosition());
            } else if (choice == 2) {
                ph.occupyPosition(new FinishPosition());
            } else if (choice == 3) {
                ph.occupyPosition(new ObstaclePosition());
            } else if (choice == 4) {
                addRandomObstacles(m.getFields());
            } else if (choice == 5) {
                String[][] fields = m.getFields();
                if (checkSFPositions(fields)) {
                    solveMaze(fields, 0, 0, 0);
                } else {
                    System.out.println("No start and/or finish positions have been set!");
                }
            } else if (choice == 6) {
                m.printMaze();
            } else if (choice == 7) {
                mv.retrieve(m);
            } else if (choice == 8) {
                mv.store(m);
            }
        }
    }

    public static void solveMaze(String[][] fields, int x, int y, int count) {
        // UP -> X, Y - 1
        // DOWN CELL -> X, Y + 1
        // RIGHT CELL -> X+1, Y
        // LEFT CELL -> X-1, Y

        if (x == 10 || y == 10) {
            x = x - 1;
            y = y - 1;
        }

        if (fields[x][y].equalsIgnoreCase("F")) {
            System.out.println("COUNT[F]: " + count);
            return;
        }

        if (fields[x][y].equalsIgnoreCase("-") || fields[x][y].equalsIgnoreCase("O")) {

            return;
        }

        if (!(fields[x][y].equalsIgnoreCase("S") || fields[x][y].equalsIgnoreCase("F")
                || fields[x][y].equalsIgnoreCase("O"))) {
            fields[x][y] = "-";
        }

        if (x == 0) {// Cannot go left, only right
            solveMaze(fields, x + 1, y, count + 1);
            return;
        }
        if (y == 0) { // Cannot go up, only down
            solveMaze(fields, x, y + 1, count + 1);
            return;
        }

        if ((x > 0 && x < 10) && (y > 0 && y < 10)) {
            solveMaze(fields, x, y + 1, count + 1);
            solveMaze(fields, x + 1, y, count + 1);
            solveMaze(fields, x - 1, y, count + 1);
            solveMaze(fields, x, y - 1, count + 1);
        }

        if (x == 9 && y == 9) {
            fields[x][y] = "-";
            return;
        }

    }

    public static boolean checkSFPositions(String fields[][]) {
        boolean start = false;
        boolean finish = false;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (fields[x][y].equalsIgnoreCase("S")) {
                    start = true;
                }
                if (fields[x][y].equalsIgnoreCase("F")) {
                    finish = true;
                }
            }
        }
        return start && finish;
    }

    public static void addRandomObstacles(String fields[][]) {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        int count = 0;
        while (count < 10) {
            if (fields[x][y].equalsIgnoreCase("O")) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                continue;
            } else {
                fields[x][y] = "O";
            }
            count++;
        }

    }

}
