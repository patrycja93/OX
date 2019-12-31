package pl.patrycja.ox.ui;

/**
 * A class InputChecker is responsible for checking input from user.
 *
 * @author Patrycja Hyjek
 */
public class InputChecker {

    /**
     * This method is called to check if number is Integer. It returns true
     * in case it is an Integer, otherwise returns false.
     *
     * @param number is an argument to check if it is an Integer
     */
    public static boolean checkNumber(String number, UI ui) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;
        } catch (IllegalArgumentException e) {
            ui.display("Wrong argument. Please write a number.");
            return false;
        }
    }

    /**
     * This method is called to check if number is in a range form 1 to board size.
     *
     * @param number    is an argument to check if it is in a range
     * @param boardSize is an upper range
     */
    public static boolean checkPositiveNumber(String number, int boardSize, UI ui) {
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
