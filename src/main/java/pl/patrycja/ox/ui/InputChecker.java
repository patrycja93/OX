package pl.patrycja.ox.ui;

import pl.patrycja.ox.Sign;

import java.util.Arrays;

/**
 * A class InputChecker is responsible for checking input from user.
 *
 * @author Patrycja Hyjek
 */
public class InputChecker {

    private UI ui;

    public InputChecker() {
    }

    public InputChecker(UI ui) {
        this.ui = ui;
    }

    /**
     * Returns number when it's type is an Integer from 1 to board size.
     *
     * @param boardSize
     * @return int number
     */
    public int getValidNumber(int boardSize) {
        String input = ui.read();
        while (!checkIfInteger(input)
                || !checkIfNumberIsInRange(input, boardSize, ui)) {
            input = ui.read();
        }
        return Integer.parseInt(String.valueOf(input));
    }

    public void checkIfInputParametersAreInteger(String[] parameters) {
        try {
            for (String p : parameters) {
                Integer.parseInt(String.valueOf(p));
            }
        } catch (IllegalArgumentException e) {
            ui.display("Entered wrong arguments. Please run the game again with correct integer numbers.");
            System.exit(0);
        }
    }

    public void checkIfUnbrokenLineIsMoreThanBoardSize(String[] parameters) {
        if (parameters.length > 1 && (Integer.parseInt(parameters[0]) < Integer.parseInt(parameters[1]))) {
            int defaultValue = 3;
            String min = String.valueOf(Math.max(Integer.parseInt(parameters[0]), defaultValue));
            String max = String.valueOf(Math.max(Integer.parseInt(parameters[1]), defaultValue));
            parameters[0] = max;
            parameters[1] = min;
            ui.display("Unbroken number of sign cannot be greater then board size and less than 3. Values was changed.\n" +
                    "Board size is " + max + ", unbroken number of sign is " + min + ".");
        }
    }

    public boolean checkIfInteger(String number) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean checkIfNumberIsInRange(String number, int boardSize, UI ui) {
        try {
            int input = Integer.parseInt(String.valueOf(number));
            if (input > 0 && input <= boardSize * boardSize) {
                return true;
            } else {
                ui.display("Argument has to be more than 0 and less than " + ((boardSize * boardSize) + 1) + ".");
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Sign checkSignValidate(String sign) {
        while (!Arrays.toString(Sign.values()).contains(sign)) {
            ui.display("Inappropriate sign, please choose O or X.");
            sign = ui.read();
        }
        return Sign.valueOf(sign);
    }
}
