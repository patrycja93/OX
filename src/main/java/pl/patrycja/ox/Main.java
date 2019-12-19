package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;

public class Main {

    public static void main(String[] args) {

        Board board = BoardFactory.boardCreator().createBoard(30);
        board.displayBoard();

        boolean result = board.putSignToBoard(3, Sign.CROSS);
        board.displayBoard();
        System.out.println(result);
    }
}
