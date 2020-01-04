package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.ui.InputChecker;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;

abstract class Mode {

    protected GameSettings gameSettings;
    protected UI ui;

    public Mode(UI ui) {
        this.ui = ui;
    }

    void play(List<Player> players) {
        gameSettings.setPlayer();
        PlayerChanger playerChanger = new PlayerChanger(players, gameSettings);

        for (int i = 0; i < gameSettings.getNumberOfMatches(); i++) {
            List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
            //TODO: changes game setting on boardSize
            Match.init(gameSettings, spectators)
                    .addController(playerChanger)
                    .start();
        }
    }

    abstract List<Player> createPlayers();

    abstract void settings(String[] inputArrayParameters);

    protected void checkCorrectInputData(String[] inputArrayParameters) {
        InputChecker inputChecker = new InputChecker(ui);
        inputChecker.getValidNumberFromInputArray(inputArrayParameters);
    }
}
