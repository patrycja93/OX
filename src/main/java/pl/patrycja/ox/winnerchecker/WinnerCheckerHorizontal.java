package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;

import java.util.Map;
import java.util.function.Predicate;

class WinnerCheckerHorizontal implements WinnerChecker {

    private GameSettings gameSettings;

    public WinnerCheckerHorizontal(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int boardSize = gameSettings.getBoardSize();
        int rowNumber = lastShot / boardSize;
        int min = rowNumber * boardSize;
        int max = ((rowNumber + 1) * boardSize) - 1;

        Predicate<Integer> predicate = i -> fields.containsKey(i) && (fields.get(i) == sing);

        counter = checkHorizon(predicate, counter, -(lastShot - 1), min);
        counter = checkHorizon(predicate, counter, lastShot + 1, max);

        return counter >= gameSettings.getUnbrokenLine();
    }

    private int checkHorizon(Predicate<Integer> predicate, int counter, int min, int max) {
        for (int i = min; Math.abs(i) <= max; i = Math.abs(i) + 1) {
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }
}
