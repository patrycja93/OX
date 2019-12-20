package pl.patrycja.ox.winnerchecker;

public class GameSettings {

    public int unbrokenLine;
    public int matchesNumber;
    public int boardSize;

    public GameSettings() {
        this.unbrokenLine = 3;
        this.matchesNumber = 3;
        this.boardSize = 3;
    }

    public GameSettings(int unbrokenLine, int matchesNumber, int boardSize) {
        this.unbrokenLine = unbrokenLine;
        this.matchesNumber = matchesNumber;
        this.boardSize = boardSize;
    }

}
