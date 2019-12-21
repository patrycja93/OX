package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

import java.util.List;
import java.util.Map;

class Judge implements Spectator {

    private GameSettings gameSettings;
    private UI ui = UIFactory.setUI();
    private List<WinnerChecker> winnerCheckers = WinnerCheckerFactory.getWinnerCheckers();

    public Judge(GameSettings gameSettings) {
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
        ui.display("Match number : " + gameSettings.matchNumber + ". Winner is " + Sign.CROSS);
        gameSettings.matchNumber -= 1;
    }

    @Override
    public void matchSummary() {
        if (gameSettings.matchNumber == 0) {
            GameSettings.END_GAME = true;
            ui.display("End game!");
        }
    }

}
