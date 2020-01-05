package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;

class Match {

    private Board board;
    private List<Spectator> spectators;
    private UI ui;
    private List<Player> players;
    private Player activePlayer;
    private boolean endMatch;

    private Match(Board board, List<Spectator> spectators, UI ui) {
        this.board = board;
        this.spectators = spectators;
        this.endMatch = false;
        this.ui = ui;
    }

    static Match init(int size, UI ui, List<Spectator> spectators) {
        Board board = BoardFactory.createBoard(size, spectators);
        return new Match(board, spectators, ui);
    }

    public Match addPlayers(List<Player> players, Player activePlayer) {
        this.players = players;
        this.activePlayer = activePlayer;
        return this;
    }

    void start(int numberOfMatch) {
        //TODO: ask about language
        board.startMatch(numberOfMatch, activePlayer);
        while (!endMatch) {
            nextTurn();
        }
        board.clean();
    }

    private void nextTurn() {
        getFieldNumber();
        checkIfMatchIsFinished(spectators);
        changePlayer();
        move(activePlayer);
    }

    private void move(Player activePlayer) {
        spectators.forEach(spectator -> spectator.playerHasChanged(activePlayer));
    }

    public void checkIfMatchIsFinished(List<Spectator> spectators) {
       endMatch = spectators.stream().anyMatch(Spectator::isMatchOver);
    }

    private void getFieldNumber() {
        int field = ui.readNumber();
        while (!board.putSign(field, activePlayer)) {
            field = ui.readNumber();
        }
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