package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Observable;
import pl.patrycja.ox.board.Board;
import pl.patrycja.ox.board.BoardFactory;
import pl.patrycja.ox.ui.InputChecker;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;

class Match implements Observable {

    private Board board;
    private List<Spectator> spectators;
    private GameSettings gameSettings;
    private PlayerChanger playerChanger;
    private boolean endMatch;

    private Match(Board board, List<Spectator> spectators, GameSettings gameSettings) {
        this.board = board;
        this.spectators = spectators;
        this.endMatch = false;
        this.gameSettings = gameSettings;
    }

    static Match init(GameSettings gameSettings, List<Spectator> spectators) {
        Board board = BoardFactory.createBoard(gameSettings.getBoardSize(), spectators);
        return new Match(board, spectators, gameSettings);
    }

    Match addController(PlayerChanger playerChanger) {
        this.playerChanger = playerChanger;
        return this;
    }

    void start() {
        //TODO: ask about language
        gameSettings.getUi().display(board);
        while (!endMatch) {
            turn();
            playerChanger.changePlayer();
        }
        board.clean();
    }

    @Override
    public void inform(List<Spectator> spectators) {
        endMatch = spectators.stream().anyMatch(Spectator::isMatchOver);
    }

    private void turn() {
        getFieldNumber();
        inform(spectators);
        gameSettings.getUi().display(board);
    }

    private void getFieldNumber() {
        InputChecker inputChecker = new InputChecker(gameSettings.getUi());
        int boardSize =  gameSettings.getBoardSize();
        int fieldNumber = inputChecker.getValidNumber(boardSize);

        while (!board.putSignToBoard(fieldNumber, playerChanger.getActivePlayerSign())) {
            gameSettings.getUi().display("This place is already occupied. Try again.");
            fieldNumber = inputChecker.getValidNumber(boardSize);
        }
    }
}