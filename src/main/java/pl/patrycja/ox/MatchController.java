package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatchController {

    private List<Player> players;
    private UI ui = UIFactory.setUI();
    private Player activePlayer;

    public MatchController(List<Player> players) {
        this.players = players;
    }

    void changePlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == activePlayer) {
                if (i + 1 < players.size()) {
                    activePlayer = players.get(i + 1);
                } else {
                    activePlayer = players.get(0);
                }
            }
        }
    }

    void setPlayer() {
        Sign playerSign = askWhichPlayerStarts();
        activePlayer = players.stream().filter(player -> player.sign == playerSign).collect(Collectors.toList()).get(0);
    }

    public Sign getActivePlayerSign() {
        return activePlayer.sign;
    }

    private Sign askWhichPlayerStarts() {
        ui.display("Which player should start: O or X ? ");
        Scanner scanner = ui.read();
        String sign = scanner.nextLine();
        while (!sign.equals(Sign.CROSS.toString()) && !sign.equals(Sign.NAUGHT.toString())) {
            sign = scanner.nextLine();
        }
        return Sign.valueOf(sign);
    }
}
