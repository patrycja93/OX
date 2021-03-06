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
        Sign sign = fields.get(lastShot);
        int boardSize = gameSettings.getBoardSize();
        int rowNumber = lastShot / boardSize;
        int min = rowNumber * boardSize;
        int max = ((rowNumber + 1) * boardSize) - 1;

        Predicate<Integer> predicate = i ->
                fields.containsKey(i) && (fields.get(i) == sign);

        counter = checkHorizon(predicate, counter, -(lastShot - 1), min, -1);
        counter = checkHorizon(predicate, counter, lastShot + 1, max, 1);

        return counter >= gameSettings.getUnbrokenLine();
    }

    private int checkHorizon(Predicate<Integer> predicate,
                             int counter, int min, int max, int swipe) {
        for (int i = min; i <= max * swipe; i = i + 1) {
            if (predicate.test(Math.abs(i))) {
                counter = counter + 1;
            } else {
                break;
            }
        }
        return counter;
    }
}
