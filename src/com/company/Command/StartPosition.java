package com.company.Command;

import java.util.Scanner;

import com.company.Iterator.MazeIterator;
import com.company.Singleton.Maze;

public class StartPosition implements Position {

    private Maze m;

    @Override
    public void execute(Maze m) {
        Scanner input = new Scanner(System.in);
        String[][] fields = m.getFields();
        MazeIterator mi = new MazeIterator(m.getFields());
        while (mi.hasNext()) {
            if (mi.next().equalsIgnoreCase("S")) {
                System.out.println("Maze already has a start position!");
                return;
            }
        }

        while (true) {
            try {
                System.out.print("Please enter a position in the form of NxN: ");
                String position = input.nextLine();
                if (position.length() != 3 || !position.substring(1, 2).equalsIgnoreCase("x")) {
                    System.out.println("Wrong input, please write correct input!: ");
                }

                fields[Integer.parseInt(position.substring(0, 1))][Integer.parseInt(position.substring(2))] = "S";
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please write correct input!: ");
            }
        }

        System.out.println("Start Position added successfully.");

        // Set start position

    }

}
