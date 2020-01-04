package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;

/**
 * Holding all settings for particular game.
 *
 * @author Patrycja Hyjek
 */
public class GameSettings {

    private static final int DEFAULT_VALUE = 3;
    private Sign firstPlayer;
    private int unbrokenLine;
    private int numberOfMatches;
    private int boardSize;
    private UI ui;

    /**
     * Creates and return object GameSettings consist of
     * unbrokenLine, matchNumber, boardSize and ui.
     * All variables has default values.
     */
    public static final class GameSettingsBuilder {
        private int unbrokenLine = DEFAULT_VALUE;
        private int matchNumber = DEFAULT_VALUE;
        private int boardSize = DEFAULT_VALUE;
        private UI ui;

        /**
         * Set number of unbrokenLine
         *
         * @param unbrokenLine is number of unbroken line sf sign
         */
        public GameSettingsBuilder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = Math.max(unbrokenLine, DEFAULT_VALUE);
            return this;
        }

        /**
         * Set how much matches will be in the game
         *
         * @param matchesNumber is amount of matches
         */
        public GameSettingsBuilder matchesNumber(int matchesNumber) {
            this.matchNumber = Math.max(matchesNumber, DEFAULT_VALUE);
            return this;
        }

        /**
         * Set how large will be board
         *
         * @param boardSize is size of the game's board
         */
        public GameSettingsBuilder boardSize(int boardSize) {
            this.boardSize = Math.max(boardSize, DEFAULT_VALUE);
            return this;
        }

        /**
         * Set kind of UI
         *
         * @param ui say from where get the input data and where to display messages
         */
        public GameSettingsBuilder ui(UI ui) {
            this.ui = ui;
            return this;
        }

        /**
         * Returns object GameSettings
         */
        public GameSettings build() {
            checkIfUnbrokenLineIsGreaterThanBoardSize();
            GameSettings gameSettings = new GameSettings();
            gameSettings.unbrokenLine = this.unbrokenLine;
            gameSettings.numberOfMatches = this.matchNumber;
            gameSettings.boardSize = this.boardSize;
            gameSettings.ui = this.ui;
            return gameSettings;
        }

        private void checkIfUnbrokenLineIsGreaterThanBoardSize() {
            if (unbrokenLine > boardSize) {
                int maxBoardSize = Math.max(boardSize, unbrokenLine);
                int minUnbrokenLine = Math.min(boardSize, unbrokenLine);
                boardSize = maxBoardSize;
                unbrokenLine = minUnbrokenLine;
                ui.display("Unbroken number of sign cannot be greater then board size. Values was switched.\n" +
                        "Board size is " + maxBoardSize + ", unbroken number of sign is " + minUnbrokenLine + ".");
            }
        }
    }

    /**
     * Returns object GameSettingsBuilder
     */
    public static GameSettingsBuilder builder() {
        return new GameSettingsBuilder();
    }

    /**
     * Set player which will be start a game
     */
    public void setPlayer() {
        this.firstPlayer = askWhichPlayerStarts();
    }

    /**
     * Return number of unbroken line
     */
    public int getUnbrokenLine() {
        return unbrokenLine;
    }

    /**
     * Return match number
     */
    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    /**
     * Return board size
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * Return player who starts a game
     */
    public Sign getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * Returns UI
     */
    public UI getUi() {
        return ui;
    }

    private Sign askWhichPlayerStarts() {
        ui.display("Which player should start: O or X ? ");
        String sign = ui.read();
        while (!sign.equals(Sign.CROSS.sign) && !sign.equals(Sign.NAUGHT.sign)) {
            sign = ui.read();
        }
        return Sign.getSign(sign);
    }
}