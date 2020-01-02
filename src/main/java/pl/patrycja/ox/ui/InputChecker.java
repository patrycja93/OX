package pl.patrycja.ox.ui;

/**
 * A class InputChecker is responsible for checking input from user.
 *
 * @author Patrycja Hyjek
 */
public class InputChecker {

    private UI ui;
    private int boardSize;

    public InputChecker(UI ui, int boardSize) {
        this.ui = ui;
        this.boardSize = boardSize;
    }

    /**
     * Returns number when it's type is an Integer from 1 to board size.
     * @return int number
     */
    public int getValidNumber() {
        String input = ui.read();
        while (!checkIfInteger(input, ui)
                || !checkIfNumberIsInRange(input, boardSize, ui)) {
            input = ui.read();
        }
        return Integer.parseInt(String.valueOf(input));
    }

    private boolean checkIfInteger(String number, UI ui) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;
        } catch (IllegalArgumentException e) {
            ui.display("Wrong argument. Please write a number.");
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
}
