package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.List;

class MatchController {

    private final List<Player> players;
    private Sign activePlayerSign = Sign.getSign(GameSettings.FIRST_PLAYER.toString());

    MatchController(List<Player> players) {
        this.players = players;
    }

    void changePlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).sign == activePlayerSign) {
                if (i + 1 < players.size()) {
                    activePlayerSign = Sign.getSign(players.get(i + 1).sign.toString());
                    break;
                } else {
                    activePlayerSign = Sign.getSign(players.get(0).sign.toString());
                }
            }
        }
    }

    Sign getActivePlayerSign() {
        return activePlayerSign;
    }
}
