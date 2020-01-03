package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;

class Game {

    private GameSettings gameSettings;

    private Player firstPlayer = new Player("A", Sign.CROSS);
    private Player secondPlayer = new Player("B", Sign.NAUGHT);

    Game(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    void play() {
        gameSettings.setPlayer();
        PlayerChanger playerChanger = new PlayerChanger(List.of(firstPlayer, secondPlayer), gameSettings);

        for (int i = 0; i < gameSettings.getNumberOfMatches(); i++) {
            List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
            Match.init(gameSettings, spectators)
                    .addController(playerChanger)
                    .start();
        }
    }
}
