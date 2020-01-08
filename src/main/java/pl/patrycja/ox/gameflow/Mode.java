package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ScoreBoard;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;

import java.util.List;

abstract class Mode {

    protected GameSettings gameSettings;
    protected UI ui;

    public Mode(UI ui) {
        this.ui = ui;
    }

    abstract void play(List<Player> players);

    abstract List<Player> createPlayers();

    abstract void settings(String[] inputArrayParameters);

    Judge createJudge(List<Player> players) {
        ScoreBoard scoreBoard = new ScoreBoard(players);
        return new Judge(gameSettings, ui, scoreBoard);
    }

    Player askWhichPlayerStarts(List<Player> players) {
        ui.display("get_initial_sign");
        Sign sign = ui.getSign();
        //noinspection OptionalGetWithoutIsPresent player always be there
        return players.stream().filter(player -> player.getSign().equals(sign)).findFirst().get();
    }
}
