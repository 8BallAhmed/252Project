package com.company.Memento;

import java.util.ArrayList;

public class MazeCaretaker {

    private ArrayList<MazeMemento> mementoList = new ArrayList<MazeMemento>();

    public void add(MazeMemento bm) {
        mementoList.add(bm);
    }

    public MazeMemento get(int i) {
        return mementoList.get(i);
    }

}
