package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.List;

class MatchController {

    private List<Player> players;
    private Sign activePlayer = Sign.getSign(GameSettings.FIRST_PLAYER.toString());

    MatchController(List<Player> players) {
        this.players = players;
    }

    void changePlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).sign == activePlayer) {
                if (i + 1 < players.size()) {
                    activePlayer = Sign.getSign(players.get(i + 1).sign.toString());
                    break;
                } else {
                    activePlayer = Sign.getSign(players.get(0).sign.toString());
                }
            }
        }
    }

    Sign getActivePlayer() {
        return activePlayer;
    }
}
