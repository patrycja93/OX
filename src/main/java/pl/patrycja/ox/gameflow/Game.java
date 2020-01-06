package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

class Game extends Mode {

    private static final int DEFAULT_VALUE = 3;
    private static final int MAXIMUM_AMOUNT_OF_PARAMETERS = 2;

    public Game(UI ui) {
        super(ui);
    }

    @Override
    public List<Player> createPlayers() {
        ui.display("put_first_player_name");
        Player firstPlayer = new Player(ui.read(), Sign.X);
        ui.display(firstPlayer);
        ui.display("put_second_player_name");
        Player secondPlayer = new Player(ui.read(), Sign.O);
        ui.display(secondPlayer);
        return List.of(firstPlayer, secondPlayer);
    }

    @Override
    public void settings(String[] inputArrayParameters) {
        ui.getLanguage();
        gameSettings = setup(inputArrayParameters);
    }

    private GameSettings setup(String[] inputArrayParameters) {
        return updateValuesForBoardAndUnbrokenLine(inputArrayParameters);
    }

    private GameSettings updateValuesForBoardAndUnbrokenLine(String[] inputArrayParameters) {
        int boardSize = Integer.parseInt(inputArrayParameters[0]);
        int unbrokenLine = DEFAULT_VALUE;
        if (inputArrayParameters.length == MAXIMUM_AMOUNT_OF_PARAMETERS) {
            unbrokenLine = Integer.parseInt(inputArrayParameters[1]);
        }

        return GameSettings.builder()
                .boardSize(boardSize)
                .unbrokenLine(unbrokenLine)
                .build();
    }
}