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
        if (fields.size() >= (gameSettings.getUnbrokenLine() * 2) - 1) {
            winnerCheckers.forEach(winnerChecker -> {
                if (winnerChecker.checkingWinnerCondition(fields, lastShot)) {
                    finishMatch(fields.get(lastShot));
                }
            });
        }
    }

    private void finishMatch(Sign sign) {
        gameSettings.setEndMatch(true);
        gameSettings.getUi().display("Winner is " + sign + ".");
        gameSettings.reduceMatchNumber();
    }

    @Override
    public void matchSummary() {
        if (gameSettings.getMatchNumber() == 0) {
            gameSettings.setEndGame(true);
            gameSettings.getUi().display("End game!");
        }
    }
}
