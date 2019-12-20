package pl.patrycja.ox;

import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;
import java.util.Scanner;

class Match implements Observable {

    Board board;
    List<Spectator> spectators;
    UI ui;

    public Match(Board board, List<Spectator> spectators, UI ui) {
        this.board = board;
        this.spectators = spectators;
        this.ui = ui;
    }

    public static Match init(GameSettings gameSettings, UI ui) {
        List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
        Board board = BoardFactory.createBoard(gameSettings.boardSize);
        return new Match(board, spectators, ui);
    }

    public void startNewMatch() {
        while (!GameSettings.END_MATCH) {
            Scanner read = ui.read();
            board.putSignToBoard(Integer.parseInt(read.nextLine()), Sign.CROSS);
            ui.display(board.toString());
            board.inform(spectators);
        }
        inform(spectators);
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(Spectator::matchSummary);
    }
}
