package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.List;
import java.util.Map;

class Judge implements Spectator{

    private List<WinnerChecker> winnerCheckers = WinnerCheckerFactory.getWinnerCheckers();
    private GameSettings gameSettings;

    public Judge(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {
        if (fields.size() >= (gameSettings.unbrokenLine * 2) - 1) {
            winnerCheckers.forEach(winnerChecker -> {
                if (winnerChecker.checkingWinnerCondition(fields, lastShot, gameSettings)) {
                    finishMatch(fields.get(lastShot));
                }
            });
        }
    }

    private void finishMatch(Sign sign) {
        GameSettings.END_MATCH = true;
        gameSettings.ui.display("Winner is " + sign + ".");
        gameSettings.matchNumber -= 1;
    }

    @Override
    public void matchSummary() {
        if (gameSettings.matchNumber == 0) {
            GameSettings.END_GAME = true;
            gameSettings.ui.display("End game!");
        }
    }
}
