package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.Observable;
import pl.patrycja.ox.ui.UI;

import java.util.List;
import java.util.Scanner;

public class Match implements Observable {

    UI ui;
    Board board;
    List<Spectators> spectators;
    Judge judge;

    public Match(UI ui, Board board, List<Spectators> spectators, Judge judge) {
        this.ui = ui;
        this.board = board;
        this.spectators = spectators;
        this.judge = judge;
    }

    public void start() {
        do {
            Scanner read = ui.read();
            board.putSignToBoard(Integer.parseInt(read.nextLine()), Sign.CROSS);
            ui.display(board.toString());
            board.inform(spectators);
        } while (!judge.isFinishMatch());
    }

    @Override
    public void inform(List<Spectators> spectators) {
        spectators.forEach(Spectators::matchFinished);
    }
}
