package pl.patrycja.ox;

import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;

public class Game {

    public static void main(String[] args) {

        GameSettings gameSettings = GameSettings.builder()
                .boardSize(6)
                .unbrokenLine(7)
                .build();

        UI ui = new ConsoleUI();

        Match match = Match.init(gameSettings, ui);
        while (gameSettings.matchNumber > 0) {
            match.startNewMatch();
        }
    }
}
