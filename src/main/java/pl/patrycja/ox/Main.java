package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UI ui = new ConsoleUI();
        List<Spectators> spectators = new ArrayList<>();
        spectators.add(new Judge());

        Board board = BoardFactory.createBoard(10);
        ui.display(board.toString());

        board.putSignToBoard(3, Sign.CROSS);
        ui.display(board.toString());

        board.inform(spectators);
    }
}
