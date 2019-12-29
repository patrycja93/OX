package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

import java.util.Scanner;

/**
 * @author Patrycja Hyjek
 *
 */

public class GameSettings {

    private boolean endGame = false;
    private boolean endMatch = false;
    private Sign firstPlayer = Sign.CROSS;
    private int unbrokenLine;
    private int matchNumber;
    private int boardSize;
    private UI ui;

    public static final class GameSettingsBuilder {
        private int unbrokenLine = 3;
        private int matchNumber = 3;
        private int boardSize = 3;
        private UI ui = UIFactory.setUI();

        public GameSettingsBuilder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = unbrokenLine;
            return this;
        }

        public GameSettingsBuilder matchesNumber(int matchesNumber) {
            this.matchNumber = matchesNumber;
            return this;
        }

        public GameSettingsBuilder boardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public GameSettingsBuilder ui(UI ui) {
            this.ui = ui;
            return this;
        }

        public GameSettings build() {
            if (unbrokenLine > boardSize) {
                //TODO: add exception handling
                throw new IllegalStateException("Unbroken number of sign cannot be greater then board size.");
            } else {
                GameSettings gameSettings = new GameSettings();
                gameSettings.unbrokenLine = this.unbrokenLine;
                gameSettings.matchNumber = this.matchNumber;
                gameSettings.boardSize = this.boardSize;
                gameSettings.ui = this.ui;
                return gameSettings;
            }
        }
    }

    public static GameSettingsBuilder builder() {
        return new GameSettingsBuilder();
    }

    public void setPlayer() {
        firstPlayer = askWhichPlayerStarts();
    }

    private Sign askWhichPlayerStarts() {
        ui.display("Which player should start: O or X ? ");
        String sign = ui.read();
        while (!sign.equals(Sign.CROSS.sign) && !sign.equals(Sign.NAUGHT.sign)) {
            sign = ui.read();
        }
        return Sign.getSign(sign);
    }

    public int getUnbrokenLine() {
        return unbrokenLine;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void reduceMatchNumber() {
        this.matchNumber = matchNumber - 1;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public boolean isEndMatch() {
        return endMatch;
    }

    public void setEndMatch(boolean endMatch) {
        this.endMatch = endMatch;
    }

    public Sign getFirstPlayer() {
        return firstPlayer;
    }

    public UI getUi() {
        return ui;
    }
}