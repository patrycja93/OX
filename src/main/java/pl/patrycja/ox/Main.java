package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;

public class Main {

    public static void main(String[] args) {

        Board board = BoardFactory.createBoard(30);
        System.out.println(board);
        boolean result = board.putSignToBoard(3, Sign.CROSS);
        System.out.println(board);
        System.out.println(result);
    }
}
