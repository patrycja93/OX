package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Judge implements Spectator {

    private List<WinnerChecker> winnerCheckers;
    private GameSettings gameSettings;
    private boolean isMatchOver;
    private UI ui;
    private Map<Integer, Sign> moves;

    Judge(GameSettings gameSettings, UI ui) {
        this.moves = new HashMap<>();
        this.ui = ui;
        this.gameSettings = gameSettings;
        this.winnerCheckers = WinnerCheckerFactory.getWinnerCheckers(gameSettings);
    }

    @Override
    public void putSignSuccess(int field, Player player) {
        String name = player.getName();
        Sign sign = player.getSign();
        int reducedFieldNumber = field - 1;

        completeMap(reducedFieldNumber, sign);
        int size = gameSettings.getBoardSize();
        if (isWinner(moves, reducedFieldNumber)) {
            state("Winner is " + name + "(" + sign + ").\n");
            //TODO: add points
        } else {
            if (size * size == moves.size()) {
                state("Draw!\n");
                //TODO: add points
            }
        }
    }

    @Override
    public void putSignFailureOverstepRange() {
        int boardSize = gameSettings.getBoardSize();
        ui.display("Number is over range. Please select number between 1 to " + boardSize * boardSize + ".\n");
    }

    @Override
    public void putSignFailurePlaceIsBusy() {
        ui.display("This place is already occupied. Try again.\n");
    }

    private void completeMap(int field, Sign sign) {
        moves.put(field, sign);
    }

    @Override
    public boolean isMatchOver() {
        return isMatchOver;
    }

    @Override
    public void newMatch(int number, Player player) {
        ui.display("Match number: " + number);
        ui.display("Player's " + player.getName() + "(" + player.getSign() + ") starts.\n");
        moves.clear();
        isMatchOver = false;
    }

    @Override
    public void playerHasChanged(Player player) {
        if (!isMatchOver) {
            ui.display("Player's " + player.getName() + "(" + player.getSign() + ") move.\n");
        }
    }

    private boolean isWinner(Map<Integer, Sign> fields, int lastShot) {
        int playersNumber = 2;
        int minimumNumberOfSignsWhenWinnerCanExists = (gameSettings.getUnbrokenLine() * playersNumber) - 1;
        if (fields.size() >= minimumNumberOfSignsWhenWinnerCanExists) {
            return winnerCheckers.stream().anyMatch(winnerChecker -> winnerChecker.checkingWinnerCondition(fields, lastShot));
        }
        return false;
    }

    private void state(String message) {
        ui.display(message);
        isMatchOver = true;
    }
}