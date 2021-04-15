package com.company.Visitor;

import java.io.*;

import com.company.Singleton.Maze;

public class MazeVisitor implements Visitor {

    @Override
    public void store(Maze m) throws FileNotFoundException, IOException {
        File f = new File("maze.txt");

        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        String[][] fields = m.getFields();
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields.length; y++) {
                // byte b[] = fields[x][y].getBytes();
                osw.write(fields[x][y]);
            }
        }

        osw.close();

        System.out.println("Maze saved successfuly.");
    }

    @Override
    public void retrieve(Maze m) throws IOException {
        File f = new File("maze.txt");
        String fields[][] = m.getFields();
        if (!f.exists() || (f.exists() && f.length() < 40)) {
            System.out.println("No record of Maze has been saved on file.");
            return;
        }
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields.length; y++) {
                fields[x][y] = (char) isr.read() + "";
            }
        }

        System.out.println("Maze loaded successfuly.");

    }

}
