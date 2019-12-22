package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.Map;
import java.util.function.Predicate;

public class WinnerCheckerDiagonalDown implements WinnerChecker {

    private GameSettings gameSettings;

    public WinnerCheckerDiagonalDown(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int boardSize = gameSettings.getBoardSize();
        int fieldUp = (lastShot - boardSize) - 1;
        int fieldDown = lastShot + boardSize + 1;
        int min = 0;
        int max = (boardSize * boardSize) - 1;

        Predicate<Integer> predicate = i -> fields.containsKey(i) && (fields.get(i) == sing);

        counter = checkDiagonalDown(predicate, boardSize, counter, -fieldUp, min, -1);
        counter = checkDiagonalDown(predicate, boardSize, counter, fieldDown, max, 1);

        return counter >= gameSettings.getUnbrokenLine();
    }

    int checkDiagonalDown(Predicate<Integer> predicate, int boardSize, int counter, int nextField, int max, int swipe) {
        for (int i = nextField; i < max && i > 0; i = i + boardSize + swipe) {
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }
}
