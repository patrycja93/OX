package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.Map;

public class Assessor implements Spectator {

    private UI ui;

    public Assessor(GameSettings gameSettings) {
        this.ui = gameSettings.getUi();
    }

    @Override
    public void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot) {
        Sign activePlayerSign = fields.get(lastShot);
        ui.display("Player " + fields.get(lastShot) + " put sign on " + (lastShot + 1) + ".");
        ui.display("Player " + activePlayerSign + "'s move.");
    }

    @Override
    public boolean isMatchOver() {
        return false;
    }
}