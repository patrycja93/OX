package pl.patrycja.ox.board;

import java.util.ArrayList;
import java.util.List;

class BoardExecutive implements Board {

    private int size;
    private List<Field> fields;

    BoardExecutive() {
    }

    private BoardExecutive(int size) {
        this.size = size;
        this.fields = new ArrayList<>();
    }

    @Override
    public Board createBoard(int size) {
        BoardExecutive boardExecutive = new BoardExecutive(size);
        boardExecutive.initializeBoard();
        return boardExecutive;
    }

    @Override
    public void displayBoard() {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < fields.size(); i++) {
            int maxFieldNumberLength = getFieldNumberLength(fields.size());
            int amountOfSpace = maxFieldNumberLength - getFieldNumberLength(i + 1);
            while (amountOfSpace > 0) {
                board.append(" ");
                amountOfSpace = amountOfSpace - 1;
            }
            if (fields.get(i).sign == Sign.EMPTY) {
                int index = i + 1;
                board.append(index).append(" ");
            } else {
                String sign = fields.get(i).sign + " ";
                board.append(sign).append(" ");
            }
            if (((i + 1) % size) == 0) board.append("\n");
        }
        System.out.println(board.toString());
    }

    @Override
    public void putSignToBoard(Board board) {

    }

    private void initializeBoard() {
        for (int i = 0; i < size * size; i++) {
            Field field = new Field();
            fields.add(field);
        }
    }

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }
}
