package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

class AutomaticTests extends Mode {

    AutomaticTests(UI ui) {
        super(ui);
    }

    @Override
    public List<Player> createPlayers() {
        Player firstPlayer = new Player("Henio", Sign.CROSS);
        Player secondPlayer = new Player("Olaf", Sign.NAUGHT);
        return List.of(firstPlayer, secondPlayer);
    }

    @Override
    public void settings(String[] inputArrayParameters) {
        gameSettings = setup(inputArrayParameters);
        Sequence sequence = new Sequence(gameSettings, inputArrayParameters[2]);
        sequence.generateSequence();
    }

    private GameSettings setup(String[] inputArrayParameters) {
        checkCorrectInputData(inputArrayParameters);
        //TODO: generate draw sequence!!
        return updateValuesInSettings(inputArrayParameters);
    }

    private GameSettings updateValuesInSettings(String[] inputArrayParameters) {
        GameSettings.GameSettingsBuilder gameSettings = GameSettings.builder();

        int boardSize = Integer.parseInt(inputArrayParameters[0]);
        int unbrokenLine = Integer.parseInt(inputArrayParameters[1]);
        int maxBoardSize = Math.max(boardSize, unbrokenLine);
        int minUnbrokenLine = Math.min(boardSize, unbrokenLine);
        gameSettings.boardSize(maxBoardSize);
        gameSettings.unbrokenLine(minUnbrokenLine);

        int towards = Integer.parseInt(inputArrayParameters[2]);
        gameSettings.matchesNumber(resolveNumberOfMatches(maxBoardSize, minUnbrokenLine, towards));

        return gameSettings.ui(ui).build();
    }

    private int resolveNumberOfMatches(int boardSize, int unbrokenLine, int towards) {
        switch (towards) {
            case 0:
            case 1: {
                return numberOfMatchesHorizontalAndVertical(boardSize, unbrokenLine);
            }
            case 2:
            case 3: {
                return numberOfMatchesDiagonals(boardSize, unbrokenLine);
            }
            default:
                return 3;
        }
    }

    private int numberOfMatchesDiagonals(int size, int line) {
        int move = 1;
        int space = size - line;
        int counter = space + move;
        for (int i = 1; i <= space; i++) {
            int bothSides = 2;
            counter += bothSides * (((size - i) - line) + move);
        }
        return counter;
    }

    private int numberOfMatchesHorizontalAndVertical(int size, int line) {
        int move = 1;
        int space = size - line;
        return (space + move) * size;
    }
}
