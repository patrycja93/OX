package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.List;
import java.util.Map;

class Judge implements Spectator {

    private List<WinnerChecker> winnerCheckers;
    private GameSettings gameSettings;

    public Judge(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        this.winnerCheckers = WinnerCheckerFactory.getWinnerCheckers(gameSettings);
    }

    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {
        if (isWinner(fields, lastShot)) {
            finishMatch("Winner is " + fields.get(lastShot) + ".");
        } else {
            int boardSize = gameSettings.getBoardSize();
            if (fields.size() == boardSize * boardSize) {
                finishMatch("Draw!");
            }
        }
    }

    private boolean isWinner(Map<Integer, Sign> fields, int lastShot) {
        if (fields.size() >= (gameSettings.getUnbrokenLine() * 2) - 1) {
            return winnerCheckers.stream().anyMatch(winnerChecker -> winnerChecker.checkingWinnerCondition(fields, lastShot));
        }
        return false;
    }

    private void finishMatch(String message) {
        gameSettings.setEndMatch(true);
        gameSettings.getUi().display(message);
        gameSettings.reduceMatchNumber();
    }

    @Override
    public void gameSummary() {
        if (gameSettings.getMatchNumber() == 0) {
            gameSettings.setEndGame(true);
            gameSettings.getUi().display("End game!");
        }
    }
}
