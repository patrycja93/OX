package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;

/**
 * Holding all settings for particular game.
 * @author Patrycja Hyjek
 */
public class GameSettings {

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
        private int unbrokenLine = defaultValue();
        private int matchNumber = defaultValue();
        private int boardSize = defaultValue();
        private UI ui;

        /**
         * Set number of unbrokenLine
         *
         * @param unbrokenLine is number of unbroken line sf sign
         */
        public GameSettingsBuilder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = unbrokenLine;
            return this;
        }

        /**
         * Set how much matches will be in the game
         *
         * @param matchesNumber is amount of matches
         */
        public GameSettingsBuilder matchesNumber(int matchesNumber) {
            this.matchNumber = matchesNumber;
            return this;
        }

        /**
         * Set how large will be board
         *
         * @param boardSize is size of the game's board
         */
        public GameSettingsBuilder boardSize(int boardSize) {
            this.boardSize = boardSize;
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
            if (unbrokenLine > boardSize) {
                //TODO: add exception handling
                throw new IllegalStateException("Unbroken number of sign cannot be greater then board size.");
            } else {
                GameSettings gameSettings = new GameSettings();
                gameSettings.unbrokenLine = this.unbrokenLine;
                gameSettings.numberOfMatches = this.matchNumber;
                gameSettings.boardSize = this.boardSize;
                gameSettings.ui = this.ui;
                return gameSettings;
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

    private static int defaultValue() {
        return 3;
    }
}