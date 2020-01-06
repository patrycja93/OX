package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.PutSignStatus;
import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardExecutive;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;

import java.util.List;

class Match {

    private Board board;
    private Judge judge;
    private UI ui;
    private List<Player> players;
    private Player activePlayer;
    private boolean endMatch;

    private Match(Board board, Judge judge, UI ui) {
        this.board = board;
        this.judge = judge;
        this.endMatch = false;
        this.ui = ui;
    }

    static Match init(int size, UI ui, Judge judge) {
        Board board = new BoardExecutive(size);
        board.subscribe(judge);
        return new Match(board, judge, ui);
    }

    public Match addPlayers(List<Player> players, Player activePlayer) {
        this.players = players;
        this.activePlayer = activePlayer;
        return this;
    }

    void start(int numberOfMatch) {
        //TODO: ask about language
        ui.display(board);
        judge.newMatch(numberOfMatch, activePlayer);
        while (!endMatch) {
            nextTurn();
        }
        board.clean();
    }

    private void nextTurn() {
        putSign();
        endMatch = judge.isMatchOver();
        changePlayer();
        judge.playerHasChanged(activePlayer);
    }

    private void putSign() {
        int field = ui.readNumber();
        while (board.putSign(field, activePlayer) != PutSignStatus.SUCCESS) {
            PutSignStatus putSignStatus = board.putSign(field, activePlayer);
            ui.display(putSignStatus.getMessage());
            field = ui.readNumber();
        }
        ui.display(board);
        board.notifySpectators(field, activePlayer);
    }

    private void changePlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(activePlayer)) {
                activePlayer = players.get((i + 1) % players.size());
                break;
            }
        }
    }
}