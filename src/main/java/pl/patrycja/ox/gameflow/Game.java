package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;


class Game {

    private UI ui;
    private Player firstPlayer = new Player("A", Sign.CROSS);
    private Player secondPlayer = new Player("B", Sign.NAUGHT);
    private GameSettings gameSettings;

    public Game(UI ui) {
        this.ui = ui;
        this.gameSettings = getGameSettings(ui);
    }

    public void play() {
        gameSettings.setPlayer();
        PlayerChanger playerChanger = new PlayerChanger(List.of(firstPlayer, secondPlayer), gameSettings);

        for (int i = 0; i < 3; i++) {
            List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
            Match.init(gameSettings, spectators)
                    .addController(playerChanger)
                    .start();
        }
    }

    private GameSettings getGameSettings(UI ui) {
        return GameSettings.builder()
                .boardSize(3)
                .unbrokenLine(3)
                .ui(ui)
                .build();
    }
}
