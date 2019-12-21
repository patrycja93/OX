package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;
import java.util.Scanner;

class Match implements Observable {

    Board board;
    List<Spectator> spectators;
    UI ui = UIFactory.setUI();
    GameSettings gameSettings;

    Match(Board board, List<Spectator> spectators, GameSettings gameSettings) {
        this.board = board;
        this.spectators = spectators;
        this.gameSettings = gameSettings;
    }

    public static Match init(GameSettings gameSettings) {
        List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
        Board board = BoardFactory.createBoard(gameSettings.boardSize);
        return new Match(board, spectators, gameSettings);
    }

    public void play() {
        while (gameSettings.matchNumber > 0) {
            startNewMatch();
        }
    }

    public void startNewMatch() {
        while (!GameSettings.END_MATCH) {
            ui.display(board.toString());
            Scanner read = ui.read();
            board.putSignToBoard(Integer.parseInt(read.nextLine()), Sign.CROSS);
            ui.display(board.toString());
            board.inform(spectators);
            inform(spectators);
        }
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(Spectator::matchSummary);
    }
}
