package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ScoreBoard;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.InputChecker;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;

import java.util.List;

abstract class Mode {

    protected GameSettings gameSettings;
    protected UI ui;

    public Mode(UI ui) {
        this.ui = ui;
    }

    void play(List<Player> players) {
        Judge judge = createJudge(players);
        Player initialPlayer = askWhichPlayerStarts(players);
        for (int i = 1; i <= gameSettings.getNumberOfMatches(); i++) {
            Match.init(gameSettings.getBoardSize(), ui, judge)
                    .addPlayers(players, initialPlayer)
                    .start(i);
            initialPlayer = changeInitialPlayer(players, initialPlayer);
        }
        judge.gameOver(players);
    }

    private Judge createJudge(List<Player> players) {
        ScoreBoard scoreBoard = new ScoreBoard(players);
        return new Judge(gameSettings, ui, scoreBoard);
    }

    abstract List<Player> createPlayers();

    abstract void settings(String[] inputArrayParameters);

    Player askWhichPlayerStarts(List<Player> players) {
        InputChecker inputChecker = new InputChecker(ui);
        ui.display("Which player should start: O or X ?");
        Sign sign = inputChecker.validateSign(ui.read());
        //noinspection OptionalGetWithoutIsPresent player always be there
        return players.stream().filter(player -> player.getSign().equals(sign)).findFirst().get();
    }

    private Player changeInitialPlayer(List<Player> players, Player initialPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(initialPlayer)) {
                return players.get((i + 1) % players.size());
            }
        }
        return initialPlayer;
    }
}
