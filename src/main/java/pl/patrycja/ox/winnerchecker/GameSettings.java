package pl.patrycja.ox.winnerchecker;

public class GameSettings {

    public int unbrokenLines;
    public int matchesNumber;
    public int boardSize;

    public GameSettings() {
        this.unbrokenLines = 3;
        this.matchesNumber = 3;
        this.boardSize = 3;
    }

    public GameSettings(int unbrokenLines, int matchesNumber, int boardSize) {
        this.unbrokenLines = unbrokenLines;
        this.matchesNumber = matchesNumber;
        this.boardSize = boardSize;
    }

}
