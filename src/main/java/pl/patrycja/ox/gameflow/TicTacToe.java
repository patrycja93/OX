package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.ui.InputChecker;
import pl.patrycja.ox.ui.Sequence;
import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

/**
 * A class TicTacToe presents a main class.
 *
 * @author Patrycja Hyjek
 */
class TicTacToe {

    /**
     * This method is called whenever we start a new game.
     *
     * @param args is string's array which are put on the beginning of game
     */
    public static void main(String[] args) {

        boolean ifDemo = checkIfDemo(args);

        Game game = setMode(args, ifDemo);
        game.play();
    }

    private static Game setMode(String[] args, boolean ifDemo) {
        GameSettings gameSettings;
        if (ifDemo) {
            Sequence sequence = new Sequence(args);
            sequence.generateSequence();
            gameSettings = getGameSettings(args);
        } else {
            gameSettings = GameSettings.builder()
                    .ui(UIFactory.set(false))
                    .build();
        }
        return new Game(gameSettings);
    }

    private static boolean checkIfDemo(String[] args) {
        return args.length == 3;
    }

    private static GameSettings getGameSettings(String[] args) {
        GameSettings.GameSettingsBuilder gameSettings = GameSettings.builder();

        String boardSize = args[0];
        String unbrokenLine = args[1];
        String towards = args[2];

        if (validateArguments(boardSize, unbrokenLine)) {
            setBoardSizeAndUnbrokenLine(gameSettings, boardSize, unbrokenLine, towards);
        }

        return gameSettings
                .ui(UIFactory.set(true))
                .build();
    }

    private static void setBoardSizeAndUnbrokenLine(GameSettings.GameSettingsBuilder gameSettings, String boardSize, String unbrokenLine, String towards) {
        int defaultBoardSize;
        int defaultUnbrokenLine;
        defaultBoardSize = Math.max(Integer.parseInt(boardSize), Integer.parseInt(unbrokenLine));
        defaultUnbrokenLine = Math.min(Integer.parseInt(boardSize), Integer.parseInt(unbrokenLine));
        gameSettings.boardSize(defaultBoardSize);
        gameSettings.unbrokenLine(defaultUnbrokenLine);
        if (towards != null) {
            int matches = resolveNumberOfMatches(defaultBoardSize, defaultUnbrokenLine, Integer.parseInt(towards));
            gameSettings.matchesNumber(matches);
        }
    }

    private static boolean validateArguments(String boardSize, String unbrokenLine) {
        InputChecker inputChecker = new InputChecker();
        return inputChecker.getValidNumberDemoMode(boardSize, unbrokenLine);
    }

    private static int resolveNumberOfMatches(int size, int line, int towards) {
        switch (towards) {
            case 0:
            case 1: {
                return ((size - line) + 1) * size;
            }
            case 2:
            case 3: {
                int counter = (size - line) + 1;
                for (int i = 1; i <= (size - line); i++) {
                    counter += 2 * (((size - i) - line) + 1);
                }
                return counter;
            }
            default:
                return 3;
        }
    }
}
