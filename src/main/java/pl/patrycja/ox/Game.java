package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.GameSettings;
import pl.patrycja.ox.winnerchecker.Judge;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        GameSettings gameSettings = new GameSettings(2, 3, 10);
        UI ui = new ConsoleUI();
        Judge judge = new Judge(ui);

        while (!judge.checkGameSettings(gameSettings)){
            ui.read();
        }

        List<Spectators> spectators = new ArrayList<>();
        spectators.add(judge);

        Board board = BoardFactory.createBoard(gameSettings.boardSize);
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
