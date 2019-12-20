package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.GameSettings;
import pl.patrycja.ox.winnerchecker.Judge;
import pl.patrycja.ox.winnerchecker.Match;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {

        GameSettings gameSettings = new GameSettings(2, 3, 10);
        UI ui = new ConsoleUI();
        Judge judge = new Judge(ui);
        List<Spectators> spectators = new ArrayList<>();
        spectators.add(judge);

        while (!judge.checkGameSettings(gameSettings)) {
            ui.read();
        }

        Board board = BoardFactory.createBoard(gameSettings.boardSize);
        ui.display(board.toString());

        while (gameSettings.matchesNumber > 0) {
            Match match = new Match(ui, board, spectators, judge);
            match.start();
        }
    }
}
