package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;

public class Main {

    public static void main(String[] args) {

        Board board = BoardFactory.boardCreator();
        board.createBoard(30)
                .displayBoard();
    }
}
