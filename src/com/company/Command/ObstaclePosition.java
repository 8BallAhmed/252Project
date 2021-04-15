package com.company.Command;

import java.util.Scanner;

import com.company.Singleton.Maze;

public class ObstaclePosition implements Position {

    @Override
    public void execute(Maze m) {
        Scanner input = new Scanner(System.in);
        String[][] fields = m.getFields();

        while (true) {
            try {
                System.out.print("Please enter a position in the form of NxN: ");
                String position = input.nextLine();

                if (position.length() != 3 || position.charAt(1) != 'x') {

                    System.out.println("Wrong input! Please enter a position in the form of NxN!\n");
                    continue;

                }

                int x = Integer.parseInt((char) position.charAt(0) + "");
                int y = Integer.parseInt((char) position.charAt(2) + "");
                if (fields[x][y].equalsIgnoreCase("o")) {
                    System.out.println("Obstacle already exists! Removing from position.");
                    fields[x][y] = "";
                    break;
                } else {
                    fields[x][y] = "O";
                    System.out.println("Obstacle successfully added.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Wrong input, please write correct input!: ");
            }
        }

        // Set start position

    }

}
