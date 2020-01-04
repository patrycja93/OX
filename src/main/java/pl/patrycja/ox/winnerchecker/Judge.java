package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.List;
import java.util.Map;

class Judge implements Spectator {

    private List<WinnerChecker> winnerCheckers;
    private GameSettings gameSettings;
    private boolean isMatchOver;

    public Judge(GameSettings gameSettings) {
        this.isMatchOver = false;
        this.gameSettings = gameSettings;
        this.winnerCheckers = WinnerCheckerFactory.getWinnerCheckers(gameSettings);
    }

    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {
        if (isWinner(fields, lastShot)) {
            isMatchOver("Winner is " + fields.get(lastShot) + ".\n");
        } else {
            int boardSize = gameSettings.getBoardSize();
            if (fields.size() == boardSize * boardSize) {
                isMatchOver("Draw!\n");
            }
        }
    }

    @Override
    public boolean isMatchOver() {
        return isMatchOver;
    }

    private boolean isWinner(Map<Integer, Sign> fields, int lastShot) {
        int playersNumber = 2;
        int minimumNumberOfSignsWhenWinnerCanExists = (gameSettings.getUnbrokenLine() * playersNumber) - 1;
        if (fields.size() >= minimumNumberOfSignsWhenWinnerCanExists) {
            return winnerCheckers.stream().anyMatch(winnerChecker -> winnerChecker.checkingWinnerCondition(fields, lastShot));
        }
        return false;
    }

    private void isMatchOver(String message) {
        gameSettings.getUi().display(message);
        isMatchOver = true;
    }
}
