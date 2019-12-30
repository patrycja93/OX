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

    Match(Board board, List<Spectator> spectators, GameSettings gameSettings) {
        this.board = board;
        this.spectators = spectators;
        this.gameSettings = gameSettings;
    }

    static Match init(GameSettings gameSettings, List<Spectator> spectators) {
        Board board = BoardFactory.createBoard(gameSettings.getBoardSize());
        gameSettings.setEndMatch(false);
        return new Match(board, spectators, gameSettings);
    }

    Match addController(PlayerChanger playerChanger) {
        this.playerChanger = playerChanger;
        return this;
    }

    void start() {
        //TODO: ask about language
        gameSettings.getUi().display(board);
        while (!gameSettings.isEndMatch()) {
            turn();
            playerChanger.changePlayer();
        }
        board.clean();
    }

    private void turn() {
        String read = gameSettings.getUi().read();
        getInputFromUser(read);
        gameSettings.getUi().display(board);
        board.inform(spectators);
        inform(spectators);
    }

    private boolean checkIfPlaceIsFree(int input) {
        if (!board.putSignToBoard(input, playerChanger.getActivePlayerSign())) {
            gameSettings.getUi().display("This place is already occupied. Try again.");
            return false;
        }
        return true;
    }

    private void getInputFromUser(String input) {
        while (isWrongInput(input)) {
            input = gameSettings.getUi().read();
        }
    }

    private boolean isWrongInput(String input) {
        return !InputChecker.checkNumber(input)
                || !InputChecker.checkPositiveNumber(input, gameSettings.getBoardSize())
                || !checkIfPlaceIsFree(Integer.parseInt(input));
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(Spectator::gameSummary);
    }
}