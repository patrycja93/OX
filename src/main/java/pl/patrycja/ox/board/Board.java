package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;

public interface Board {

    Board createBoard(int size);

    void displayBoard();

    boolean putSignToBoard(int fieldNumber, Sign sign);
}
