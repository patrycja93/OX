package pl.patrycja.ox;

public class GameSettings {

    public static boolean END_GAME = false;
    public static boolean END_MATCH = false;
    public int unbrokenLine;
    public int matchNumber;
    public int boardSize;

    public static final class Builder {
        private int unbrokenLine = 3;
        private int matchNumber = 3;
        private int boardSize = 3;

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

        public GameSettings build() {
            if (unbrokenLine > boardSize) {
                throw new IllegalStateException("Unbroken number of sign cannot be greater then board size.");
            } else {
                GameSettings gameSettings = new GameSettings();
                gameSettings.unbrokenLine = this.unbrokenLine;
                gameSettings.matchNumber = this.matchNumber;
                gameSettings.boardSize = this.boardSize;
                return gameSettings;
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
