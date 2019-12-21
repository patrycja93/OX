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
    MatchController matchController;

    Match(Board board, List<Spectator> spectators) {
        this.board = board;
        this.spectators = spectators;
    }

    public static Match init(int boardSize, List<Spectator> spectators) {
        Board board = BoardFactory.createBoard(boardSize);
        return new Match(board, spectators);
    }

    public Match addController(MatchController matchController) {
        this.matchController = matchController;
        return this;
    }

    public void start() {
        matchController.setPlayer();
        ui.display(board.toString());
        while (!GameSettings.END_MATCH) {
            turn();
            matchController.changePlayer();
        }
        board.clean();
    }

    private void turn() {
        Scanner read = ui.read();
        boolean b = board.putSignToBoard(Integer.parseInt(read.nextLine()), matchController.getActivePlayerSign());
        ui.display("b: " + b);
        ui.display(board.toString());
        board.inform(spectators);
        inform(spectators);
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(Spectator::matchSummary);
    }
}