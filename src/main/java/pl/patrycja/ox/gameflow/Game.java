package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.winnerchecker.Judge;

import java.util.List;

class Game extends Mode {

    private static final int DEFAULT_VALUE = 3;
    private static final int MAXIMUM_AMOUNT_OF_PARAMETERS = 2;

    public Game(UI ui) {
        super(ui);
    }

    @Override
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

    private Player changeInitialPlayer(List<Player> players, Player initialPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(initialPlayer)) {
                return players.get((i + 1) % players.size());
            }
        }
        return initialPlayer;
    }
}