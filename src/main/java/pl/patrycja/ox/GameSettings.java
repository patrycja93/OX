package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;

/**
 * Holding all settings for particular game.
 *
 * @author Patrycja Hyjek
 */
public class GameSettings {

    private static final int DEFAULT_VALUE = 3;
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
            GameSettings gameSettings = new GameSettings();
            gameSettings.unbrokenLine = this.unbrokenLine;
            gameSettings.numberOfMatches = this.matchNumber;
            gameSettings.boardSize = this.boardSize;
            gameSettings.ui = this.ui;
            return gameSettings;
        }
    }

    /**
     * Returns object GameSettingsBuilder
     */
    public static GameSettingsBuilder builder() {
        return new GameSettingsBuilder();
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
     * Returns UI
     */
    public UI getUi() {
        return ui;
    }
}