package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Observable;
import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;
import java.util.Scanner;

class Match implements Observable {

    private Board board;
    private List<Spectator> spectators;
    private UI ui;
    private MatchController matchController;

    Match(Board board, List<Spectator> spectators, UI ui) {
        this.board = board;
        this.spectators = spectators;
        this.ui = ui;
    }

    static Match init(int boardSize, UI ui, List<Spectator> spectators) {
        Board board = BoardFactory.createBoard(boardSize);
        GameSettings.END_MATCH = false;
        return new Match(board, spectators, ui);
    }

    Match addController(MatchController matchController) {
        this.matchController = matchController;
        return this;
    }

    void start() {
        //TODO: ask about language
        ui.display(board.toString());
        while (!GameSettings.END_MATCH) {
            turn();
            matchController.changePlayer();
        }
        board.clean();
    }

    private void turn() {
        Scanner read = ui.read();
        boolean success = board.putSignToBoard(Integer.parseInt(read.nextLine()), matchController.getActivePlayerSign());
        //TODO : if success == false ask again
        ui.display(board.toString());
        board.inform(spectators);
        inform(spectators);
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(Spectator::matchSummary);
    }
}