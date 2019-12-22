package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.Map;
import java.util.function.Predicate;

class WinnerCheckerHorizontal implements WinnerChecker {

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot, GameSettings gameSettings) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int rowNumber = lastShot / gameSettings.boardSize;
        int min = rowNumber * gameSettings.boardSize;
        int max = ((rowNumber + 1) * gameSettings.boardSize) - 1;

        Predicate<Integer> predicate = i -> fields.containsKey(i) && (fields.get(i) == sing);

        counter = checkHorizon(predicate, counter, -(lastShot - 1), min);
        counter = checkHorizon(predicate, counter, lastShot + 1, max);

        return counter >= gameSettings.unbrokenLine;
    }

    private int checkHorizon(Predicate<Integer> predicate, int counter, int min, int max) {
        for (int i = min; i <= max; i++) {
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }
}
