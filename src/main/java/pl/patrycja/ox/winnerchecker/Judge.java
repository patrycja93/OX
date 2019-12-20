package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.Map;

public class Judge implements Spectators {

    private GameSettings gameSettings;
    private UI ui;

    public Judge(UI ui) {
        this.ui = ui;
    }

    public boolean checkGameSettings(GameSettings gameSettings) {
        if (gameSettings.unbrokenLines > gameSettings.boardSize) {
            ui.display("Unbroken number of sign cannot be greater then board size.");
            return false;
        }
        this.gameSettings = gameSettings;
        return true;
    }

    @Override
    public void subscribe(Map<Integer, Sign> fields, int size, int lastShoot) {
        /*
        check if winner -> if false do nothing else change round show score
         */
        if (fields.size() > gameSettings.unbrokenLines) {
            if (checkVertical(fields, size, lastShoot) || checkHorizontal(fields, size, lastShoot)) {
                ui.display("Winner!");
            }
        }
    }

    boolean checkHorizontal(Map<Integer, Sign> fields, int size, int lastShoot) {
        int counter = 1;
        Sign sing = fields.get(lastShoot);
        int rowNumber = lastShoot / size;
        int min = rowNumber * size;
        int max = (rowNumber + 1) * size;

        for (int i = lastShoot + 1; i <= max; i++) {
            if (fields.containsKey(i)) {
                counter = counterEscalate(fields, counter, sing, i);
            } else {
                break;
            }
        }

        for (int i = lastShoot - 1; i >= min; i--) {
            if (fields.containsKey(i)) {
                counter = counterEscalate(fields, counter, sing, i);
            } else {
                break;
            }
        }
        return counter >= gameSettings.unbrokenLines;
    }

    boolean checkVertical(Map<Integer, Sign> fields, int size, int lastShoot) {
        int counter = 1;
        Sign sing = fields.get(lastShoot);
        int fieldUp = lastShoot - size;
        int fieldDown = lastShoot + size;

        while ((fieldUp) > 0) {
            if (fields.containsKey(fieldUp)) {
                if (fields.get(fieldUp) == sing) {
                    counter = counter + 1;
                    fieldUp = fieldUp - size;
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
                }
            } else {
                break;
            }
        }
        return counter >= gameSettings.unbrokenLines;
    }

    private int counterEscalate(Map<Integer, Sign> fields, int counter, Sign sing, int i) {
        if (fields.get(i) == sing) {
            counter = counter + 1;
        }
        return counter;
    }
}
