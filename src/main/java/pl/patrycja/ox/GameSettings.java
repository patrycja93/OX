package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;

/**
 * This class contains all main game's settings.
 * In this class are all values to which access have others class
 *
 * @author Patrycja Hyjek
 */
public class GameSettings {

    private boolean endGame = false;
    private boolean endMatch = false;
    private Sign firstPlayer;
    private int unbrokenLine;
    private int numberOfMatches;
    private int boardSize;
    private UI ui;

    /**
     * This class creates and return object GameSettings consist of
     * unbrokenLine, matchNumber, boardSize and ui.
     * All variables has default values.
     */
    public static final class GameSettingsBuilder {
        private int unbrokenLine = defaultValue();
        private int matchNumber = defaultValue();
        private int boardSize = defaultValue();
        private UI ui;

        /**
         * This method set number of unbrokenLine
         *
         * @param unbrokenLine is number of unbroken line sf sign
         */
        public GameSettingsBuilder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = unbrokenLine;
            return this;
        }

        /**
         * This method set how much matches will be in the game
         *
         * @param matchesNumber is amount of matches
         */
        public GameSettingsBuilder matchesNumber(int matchesNumber) {
            this.matchNumber = matchesNumber;
            return this;
        }

        /**
         * This method set how large will be board
         *
         * @param boardSize is size of the game's board
         */
        public GameSettingsBuilder boardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        /**
         * This method set kind of UI
         *
         * @param ui say from where get the input data and where to display messages
         */
        public GameSettingsBuilder ui(UI ui) {
            this.ui = ui;
            return this;
        }

        /**
         * This method returns object GameSettings
         */
        public GameSettings build() throws IllegalStateException{
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
     * This method returns object GameSettingsBuilder
     */
    public static GameSettingsBuilder builder() {
        return new GameSettingsBuilder();
    }

    /**
     * This method set player which will be start a game
     */
    public void setPlayer() {
        this.firstPlayer = askWhichPlayerStarts();
    }

    /**
     * This method return number of unbroken line
     */
    public int getUnbrokenLine() {
        return unbrokenLine;
    }

    /**
     * This method return match number
     */
    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    /**
     * This method return board size
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * This method check if game is finished
     */
    public boolean isEndGame() {
        return endGame;
    }

    /**
     * This method changes state for endGame value
     */
    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    /**
     * This method checks if match is finished
     */
    public boolean isEndMatch() {
        return endMatch;
    }

    /**
     * This method changes state for endMatch value
     */
    public void setEndMatch(boolean endMatch) {
        this.endMatch = endMatch;
    }

    /**
     * This method return player who starts a game
     */
    public Sign getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * This method returns UI
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