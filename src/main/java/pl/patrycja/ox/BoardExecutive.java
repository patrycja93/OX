package pl.patrycja.ox;

import java.util.ArrayList;
import java.util.List;

public class BoardExecutive implements Board {

    private int size;
    private List<Field> fields;

    public BoardExecutive() {
    }

    private BoardExecutive(int size) {
        this.size = size;
        this.fields = new ArrayList<>();
    }

    @Override
    public Board createBoard(int size) {
        return null;
    }

    @Override
    public void displayBoard() {

    }

    @Override
    public void putSignToBoard(Board board) {

    }

}
