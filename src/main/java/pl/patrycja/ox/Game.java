package pl.patrycja.ox;

import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //TODO: get input from user
    GameSettings gameSettings = GameSettings.builder()
            .boardSize(6)
            .unbrokenLine(3)
            .build();

    Player firstPlayer = new Player("A", Sign.CROSS);
    Player secondPlayer = new Player("B", Sign.NAUGHT);

    List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);

    MatchController matchController = new MatchController(new ArrayList<>() {{
        add(firstPlayer);
        add(secondPlayer);
    }});

    public void play() {
        while (gameSettings.matchNumber > 0) {
            Match.init(gameSettings.boardSize, spectators)
                    .addController(matchController)
                    .start();

        }
    }

}
