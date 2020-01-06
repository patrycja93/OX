package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

class AutomaticTests extends Mode {

    private final static int HORIZONTAL = 0;
    private final static int VERTICAL = 1;
    private final static int DIAGONAL_UP = 2;
    private final static int DIAGONAL_DOWN = 3;
    private final static int DRAW = 4;
    private final static int DEFAULT_NUMBER_FOR_TOWARD = 4;

    private final BinaryOperator<Integer> verticalAndHorizontal = this::numberOfMatchesHorizontalAndVertical;
    private final BinaryOperator<Integer> diagonals = this::numberOfMatchesDiagonals;
    private final BinaryOperator<Integer> draw = (a, b) -> 1;

    private final Map<Integer, BinaryOperator<Integer>> towardsMap = Map.of(
            HORIZONTAL, verticalAndHorizontal,
            VERTICAL, verticalAndHorizontal,
            DIAGONAL_UP, diagonals,
            DIAGONAL_DOWN, diagonals,
            DRAW, draw
    );

    AutomaticTests(UI ui) {
        super(ui);
    }

    @Override
    public List<Player> createPlayers() {
        Player firstPlayer = new Player("Henio", Sign.X);
        Player secondPlayer = new Player("Olaf", Sign.O);
        return List.of(firstPlayer, secondPlayer);
    }

    @Override
    public void settings(String[] inputArrayParameters) {
        ui.getLanguage();
        gameSettings = setup(inputArrayParameters);
    }

    private GameSettings setup(String[] inputArrayParameters) {
        return updateValuesInSettings(inputArrayParameters);
    }

    private GameSettings updateValuesInSettings(String[] inputArrayParameters) {
        int boardSize = Integer.parseInt(inputArrayParameters[0]);
        int unbrokenLine = Integer.parseInt(inputArrayParameters[1]);
        int towards = Integer.parseInt(inputArrayParameters[2]);

        int numberOfMatches = resolveNumberOfMatches(boardSize, unbrokenLine, towards);

        return GameSettings.builder()
                .boardSize(boardSize)
                .unbrokenLine(unbrokenLine)
                .matchesNumber(numberOfMatches)
                .build();
    }

    private int resolveNumberOfMatches(int boardSize, int unbrokenLine, int towards) {
        int towardsLessThanFour = Math.min(DEFAULT_NUMBER_FOR_TOWARD, towards);
        return towardsMap.get(towardsLessThanFour).apply(boardSize, unbrokenLine);
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