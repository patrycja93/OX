package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;


class Game {

    //TODO: get input from user
    GameSettings gameSettings = GameSettings.builder()
            .boardSize(3)
            .unbrokenLine(3)
            .build();

    Player firstPlayer = new Player("A", Sign.CROSS);
    Player secondPlayer = new Player("B", Sign.NAUGHT);

    public void play() {
        gameSettings.setPlayer();
        List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
        PlayerChanger playerChanger = new PlayerChanger(List.of(firstPlayer, secondPlayer), gameSettings);

        while (!gameSettings.isEndGame()) {
            Match.init(gameSettings, spectators)
                    .addController(playerChanger)
                    .start();
        }
    }
}
