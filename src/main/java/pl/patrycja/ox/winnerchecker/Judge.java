package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Judge implements Spectators {

    private GameSettings gameSettings;
    private UI ui;
    private boolean isFinish = false;
    private List<WinnerChecker> winnerChecker = new ArrayList<>() {{
        add(new WinnerCheckerHorizontal());
        add(new WinnerCheckerVertical());
    }};

    public Judge(UI ui) {
        this.ui = ui;
    }

    public boolean checkGameSettings(GameSettings gameSettings) {
        if (gameSettings.unbrokenLine > gameSettings.boardSize) {
            ui.display("Unbroken number of sign cannot be greater then board size.");
            return false;
        }
        this.gameSettings = gameSettings;
        return true;
    }

    //TODO: change name method
    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {

        if (fields.size() >= (gameSettings.unbrokenLine * 2) - 1) {
            winnerChecker.forEach(winnerChecker -> {
                if (winnerChecker.checkingWinnerCondition(fields, size, lastShot, gameSettings.unbrokenLine)) {
                    isFinish = true;
                    gameSettings.matchesNumber -= 1;
                }
            });
        }
    }

    @Override
    public void matchFinished() {
        ui.display("We have a winner.");
    }

    public boolean isFinishMatch() {
        return isFinish;
    }
}
