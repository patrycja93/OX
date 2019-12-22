package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

import java.util.Scanner;

public class GameSettings {

    public static boolean END_GAME = false;
    public static boolean END_MATCH = false;
    public static Sign FIRST_PLAYER = Sign.CROSS;
    public int unbrokenLine;
    public int matchNumber;
    public int boardSize;
    public UI ui;

    public static final class Builder {
        public int unbrokenLine = 3;
        public int matchNumber = 3;
        public int boardSize = 3;
        public UI ui = UIFactory.setUI();

        public Builder unbrokenLine(int unbrokenLine) {
            this.unbrokenLine = unbrokenLine;
            return this;
        }

        public Builder matchesNumber(int matchesNumber) {
            this.matchNumber = matchesNumber;
            return this;
        }

        public Builder boardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder ui(UI ui) {
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

    public static Builder builder() {
        return new Builder();
    }

    public void setPlayer() {
        FIRST_PLAYER = askWhichPlayerStarts();
    }

    private Sign askWhichPlayerStarts() {
        ui.display("Which player should start: O or X ? ");
        Scanner scanner = ui.read();
        String sign = scanner.nextLine();
        while (!sign.equals(Sign.CROSS.sign) && !sign.equals(Sign.NAUGHT.sign)) {
            sign = scanner.nextLine();
        }
        return Sign.getSign(sign);
    }
}
