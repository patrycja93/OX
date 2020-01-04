package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

class Game extends Mode {

    public Game(UI ui) {
        super(ui);
    }

    @Override
    public List<Player> createPlayers() {
        ui.display("Please enter name for first player.");
        Player firstPlayer = new Player(ui.read(), Sign.CROSS);
        ui.display("Please enter name for second player.");
        Player secondPlayer = new Player(ui.read(), Sign.NAUGHT);
        return List.of(firstPlayer, secondPlayer);
    }

    @Override
    public void settings(String[] inputArrayParameters) {
        gameSettings = setup(inputArrayParameters);
    }

    private GameSettings setup(String[] inputArrayParameters) {
        checkCorrectInputData(inputArrayParameters);
        return updateValuesForBoardAndUnbrokenLine(inputArrayParameters);
    }

    private GameSettings updateValuesForBoardAndUnbrokenLine(String[] inputArrayParameters) {
        GameSettings.GameSettingsBuilder gameSettings = GameSettings.builder();
        int firstParameter = Integer.parseInt(inputArrayParameters[0]);
        if (inputArrayParameters.length == 1) {
            gameSettings.boardSize(Math.max(firstParameter, 3));
        } else {
            int secondParameter = Integer.parseInt(inputArrayParameters[1]);
            gameSettings.boardSize(Math.max(firstParameter, secondParameter));
            gameSettings.unbrokenLine(Math.min(firstParameter, secondParameter));
        }
        return gameSettings.ui(ui).build();
    }
}
