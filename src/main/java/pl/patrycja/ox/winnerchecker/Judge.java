package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;
import java.util.Map;

class Judge implements Spectator {

    private GameSettings gameSettings;
    private UI ui;
    private List<WinnerChecker> winnerCheckers = WinnerCheckerFactory.getWinnerCheckers();

    public Judge(UI ui, GameSettings gameSettings) {
        this.ui = ui;
        this.gameSettings = gameSettings;
    }

    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {
        if (fields.size() >= (gameSettings.unbrokenLine * 2) - 1) {
            winnerCheckers.forEach(winnerChecker -> {
                if (winnerChecker.checkingWinnerCondition(fields, size, lastShot, gameSettings.unbrokenLine)) {
                    finishMatch();
                }
            });
        }
    }

    private void finishMatch() {
        GameSettings.END_MATCH = true;
        gameSettings.matchNumber -= 1;
    }

    @Override
    public void matchSummary() {
        int matchNumber = gameSettings.matchNumber;
        if (matchNumber == 0) {
            GameSettings.END_GAME = true;
            ui.display("End game!");
        }
    }

}
