package pl.patrycja.ox;

/**
 * Holding all settings for particular game.
 *
 * @author Patrycja Hyjek
 */
public class GameSettings {

    private static final int DEFAULT_VALUE = 3;
    private static final Sign DEFAULT_SIGN = Sign.X;
    private static final Language DEFAULT_LANGUAGE = Language.EN;
    private int unbrokenLine;
    private int numberOfMatches;
    private int boardSize;
    private Sign sign;
    private Language language;

    /**
     * Creates and return object GameSettings consist of
     * unbrokenLine, matchNumber and boardSize.
     * All variables have default values.
     */
    public static final class GameSettingsBuilder {
        private int unbrokenLine = DEFAULT_VALUE;
        private int matchNumber = DEFAULT_VALUE;
        private int boardSize = DEFAULT_VALUE;
        private Sign sign = DEFAULT_SIGN;
        private Language language = DEFAULT_LANGUAGE;

        /**
         * Set length of unbroken line.
         *
         * @param unbrokenLine is number of unbroken line sf sign
         */
        public GameSettingsBuilder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = Math.max(unbrokenLine, DEFAULT_VALUE);
            return this;
        }

        /**
         * Set number of matches.
         *
         * @param matchesNumber is amount of matches
         */
        public GameSettingsBuilder matchesNumber(int matchesNumber) {
            this.matchNumber = matchesNumber;
            return this;
        }

        /**
         * Set the board size.
         *
         * @param boardSize is size of the game's board
         */
        public GameSettingsBuilder boardSize(int boardSize) {
            this.boardSize = Math.max(boardSize, DEFAULT_VALUE);
            return this;
        }

        /**
         * Set the sign.
         *
         * @param sign sign which will start the game
         */
        public GameSettingsBuilder sign(Sign sign) {
            this.sign = sign;
            return this;
        }

        /**
         * Set the language.
         *
         * @param language language in the game
         */
        public GameSettingsBuilder language(Language language) {
            this.language = language;
            return this;
        }

        /**
         * Returns GameSettings object.
         */
        public GameSettings build() {
            GameSettings gameSettings = new GameSettings();
            gameSettings.unbrokenLine = this.unbrokenLine;
            gameSettings.numberOfMatches = this.matchNumber;
            gameSettings.boardSize = this.boardSize;
            gameSettings.sign = this.sign;
            gameSettings.language = this.language;
            return gameSettings;
        }
    }

    /**
     * Returns  GameSettingsBuilder object.
     */
    public static GameSettingsBuilder builder() {
        return new GameSettingsBuilder();
    }

    /**
     * Return length of unbroken line.
     */
    public int getUnbrokenLine() {
        return unbrokenLine;
    }

    /**
     * Return number of matches.
     */
    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    /**
     * Return board size.
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * Return sign.
     */
    public Sign getSign() {
        return sign;
    }
}