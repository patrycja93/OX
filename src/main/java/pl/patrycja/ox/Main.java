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

    //TODO: checking if unBrokenLine is bigger than size

    public static void main(String[] args) {

        UI ui = new ConsoleUI();
        int unBrokenLine = 2;
        int sizeBoard = 10;

        Judge judge = new Judge(unBrokenLine, ui);

        List<Spectators> spectators = new ArrayList<>();
        spectators.add(judge);

        Board board = BoardFactory.createBoard(sizeBoard);
        ui.display(board.toString());

        int n = 5;
        while (n > 0) {
            String scanner = new Scanner(System.in).nextLine();
            board.putSignToBoard(Integer.parseInt(scanner), Sign.CROSS);
            ui.display(board.toString());
            board.inform(spectators);
            n--;
        }
    }
}
