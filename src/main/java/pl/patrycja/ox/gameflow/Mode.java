package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.InputChecker;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.List;

abstract class Mode {

    protected GameSettings gameSettings;
    protected UI ui;
    private List<Spectator> spectatorsList;

    public Mode(UI ui) {
        this.ui = ui;
    }

    void play(List<Player> players) {
        Player initialPlayer = askWhichPlayerStarts(players);

        for (int i = 1; i <= gameSettings.getNumberOfMatches(); i++) {
            Match.init(gameSettings.getBoardSize(), ui, spectatorsList)
                    .addPlayers(players, initialPlayer)
                    .start(i);
        }
    }

    void createSpectators() {
        Spectators spectators = new Spectators(gameSettings, ui);
        spectatorsList = spectators.create();
    }

    abstract List<Player> createPlayers();

    abstract void settings(String[] inputArrayParameters);

    void checkIfCorrectInputData(String[] inputArrayParameters) {
        InputChecker inputChecker = new InputChecker(ui);
        inputChecker.checkIfInputParametersAreInteger(inputArrayParameters);
        inputChecker.checkIfUnbrokenLineIsMoreThanBoardSize(inputArrayParameters);
    }

    Player askWhichPlayerStarts(List<Player> players) {
        InputChecker inputChecker = new InputChecker(ui);
        ui.display("Which player should start: O or X ? ");
        Sign sign = inputChecker.checkSignValidate(ui.read());
        //noinspection OptionalGetWithoutIsPresent player always be there
        return players.stream().filter(player -> player.getSign().equals(sign)).findFirst().get();
    }
}
