package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.Map;
import java.util.function.Predicate;

class WinnerCheckerVertical implements WinnerChecker {

    private GameSettings gameSettings;

    public WinnerCheckerVertical(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int boardSize = gameSettings.getBoardSize();
        int fieldUp = lastShot - boardSize;
        int fieldDown = lastShot + boardSize;
        int min = 0;
        int max = (boardSize * boardSize) - 1;

        Predicate<Integer> predicate = i -> fields.containsKey(i) && (fields.get(i) == sing);

        counter = checkVertical(predicate, boardSize, counter, -fieldUp, min);
        counter = checkVertical(predicate, boardSize, counter, fieldDown, max);

        return counter >= gameSettings.getUnbrokenLine();
    }

    private int checkVertical(Predicate<Integer> predicate, int boardSize, int counter, int nextField, int max) {
        for (int i = nextField; i <= max; i = i + boardSize) {
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }
}
