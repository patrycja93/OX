package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UI ui = new ConsoleUI();
        List<Spectators> spectators = new ArrayList<>();
        spectators.add(new Judge());

        Board board = BoardFactory.createBoard(10);
        ui.display(board.toString());
        int n = 3;
        while (n > 0) {
            String scanner = new Scanner(System.in).nextLine();
            board.putSignToBoard(Integer.parseInt(scanner), Sign.CROSS);
            ui.display(board.toString());
            board.inform(spectators);
            n--;
        }
    }
}
