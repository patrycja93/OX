package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

class WinnerCheckerVertical implements WinnerChecker {

    @Override
    public boolean checkingWinnerCondition(Map<Integer, Sign> fields, int size, int lastShot, int unbrokenLine) {
        int counter = 1;
        Sign sing = fields.get(lastShot);
        int fieldUp = lastShot - size;
        int fieldDown = lastShot + size;

        while ((fieldUp) > 0) {
            if (fields.containsKey(fieldUp)) {
                if (fields.get(fieldUp) == sing) {
                    counter = counter + 1;
                    fieldUp = fieldUp - size;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        while ((fieldDown) < (size * size)) {
            if (fields.containsKey(fieldDown)) {
                if (fields.get(fieldDown) == sing) {
                    counter = counter + 1;
                    fieldDown = fieldDown + size;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return counter >= unbrokenLine;
    }
}
