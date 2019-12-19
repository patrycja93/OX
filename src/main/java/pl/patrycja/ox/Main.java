package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;

public class Main {

    public static void main(String[] args) {

        UI ui = new ConsoleUI();

        Board board = BoardFactory.createBoard(30);
        ui.display(board.toString());
        board.putSignToBoard(3, Sign.CROSS);
        ui.display(board.toString());
    }
}
