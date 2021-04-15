package com.company.Visitor;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.company.Singleton.Maze;

public interface Visitor {

    public void store(Maze m) throws FileNotFoundException, IOException;

    public void retrieve(Maze m) throws IOException;
}
