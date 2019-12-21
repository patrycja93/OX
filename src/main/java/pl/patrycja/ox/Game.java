package pl.patrycja.ox;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        //TODO: get input from user
        GameSettings gameSettings = GameSettings.builder()
                .boardSize(6)
                .unbrokenLine(3)
                .build();

        Player firstPlayer = new Player("A", Sign.CROSS);
        Player secondPlayer = new Player("B", Sign.NAUGHT);
        MatchController matchController = new MatchController(new ArrayList<>() {{
            add(firstPlayer);
            add(secondPlayer);
        }});

        Match.init(gameSettings)
                .addController(matchController)
                .play();
    }
}
