package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.Map;
import java.util.function.Predicate;

public class WinnerCheckerDiagonalUp implements WinnerChecker {

    private GameSettings gameSettings;

    public WinnerCheckerDiagonalUp(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int boardSize = gameSettings.getBoardSize();
        int fieldUp = (lastShot - boardSize) + 1;
        int fieldDown = lastShot + boardSize - 1;
        int min = 0;
        int max = (boardSize * boardSize) - 1;
        int rowNumber = lastShot / boardSize;

        Predicate<Integer> predicate = i -> fields.containsKey(i) && (fields.get(i) == sing);

        counter = checkDiagonalUp(predicate, boardSize, rowNumber, counter, -fieldUp, min);
        counter = checkDiagonalUp(predicate, boardSize, rowNumber, counter, fieldDown, max);

        return counter >= gameSettings.getUnbrokenLine();
    }

    int checkDiagonalUp(Predicate<Integer> predicate, int boardSize, int lastShotRowNumber, int counter, int nextField, int max) {
        for (int i = nextField; i < max && !checkRowNumber(i, boardSize, lastShotRowNumber); i = i + boardSize - 1) {
            lastShotRowNumber = Math.abs(i / boardSize);
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }

    private boolean checkRowNumber(int nextField, int boardSize, int lastShotRowNumber) {
        return (Math.abs(nextField / boardSize) - lastShotRowNumber) == 0;
    }
}
