package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;

import java.util.HashMap;
import java.util.Map;

class BoardExecutive implements Board {

    private int size;
    private Map<Integer, Sign> fields;

    BoardExecutive() {
    }

    private BoardExecutive(int size) {
        this.size = size;
        this.fields = new HashMap<>();
    }

    @Override
    public Board createBoard(int size) {
        BoardExecutive boardExecutive = new BoardExecutive(size * size);
        // boardExecutive.initializeBoard();
        return boardExecutive;
    }

    @Override
    public void displayBoard() {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int maxFieldNumberLength = getFieldNumberLength(size);
            int amountOfSpace = maxFieldNumberLength - getFieldNumberLength(i + 1);
            while (amountOfSpace > 0) {
                board.append(" ");
                amountOfSpace = amountOfSpace - 1;
            }
            if (!fields.containsKey(i)) {
                int index = i + 1;
                board.append(index).append(" ");
            } else {
                String sign = fields.get(i) + " ";
                board.append(sign).append(" ");
            }
            if (((i + 1) % Math.sqrt(size)) == 0) board.append("\n");
        }
        System.out.println(board.toString());
    }

    @Override
    public boolean putSignToBoard(int fieldNumber, Sign sign) {
        if (!fields.containsKey(fieldNumber)) {
            fields.put(fieldNumber, sign);
            return true;
        } else {
            return false;
        }
    }

 /*   private void initializeBoard() {
        for (int i = 0; i < size * size; i++) {
            Field field = new Field(i, Sign.EMPTY);
            fields.add(field);
        }
    }*/

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }
}
