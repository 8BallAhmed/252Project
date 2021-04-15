package com.company.Memento;

public class MazeOriginator {

    private String[][] fields;

    public void setFields(String[][] fields) {
        this.fields = fields;
    }

    public String[][] getFields() {
        return fields;
    }

    public MazeMemento saveToMemento() {
        return new MazeMemento(fields);
    }

    public void getStateFromMemento(MazeMemento bm) {
        fields = bm.getFields();
    }
}
