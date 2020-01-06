package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.ui.UI;

class Assessor implements Spectator {

    private UI ui;

    Assessor(UI ui) {
        this.ui = ui;
    }

    @Override
    public void signWasPut(int field, Player player) {
        ui.display("Player " + player + " put sign to " + field + ".");
    }
}