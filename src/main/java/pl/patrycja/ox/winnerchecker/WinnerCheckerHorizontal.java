package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

public class WinnerCheckerHorizontal implements WinnerChecker {

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int size, int lastShot, int unbrokenLine) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int rowNumber = lastShot / size;
        int min = rowNumber * size;
        int max = (rowNumber + 1) * size;

        for (int i = lastShot + 1; i < max; i++) {
            if (fields.containsKey(i)) {
                if (fields.get(i) == sing) {
                    counter = counter + 1;
                }
            } else {
                break;
            }
        }

        for (int i = lastShot - 1; i >= min; i--) {
            if (fields.containsKey(i)) {
                if (fields.get(i) == sing) {
                    counter = counter + 1;
                }
            } else {
                break;
            }
        }
        return counter >= unbrokenLine;
    }
}
