package pl.patrycja.ox.ui;

public class InputChecker {

    static UI ui = UIFactory.setUI();

    public static boolean checkNumber(String number) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;
        } catch (IllegalArgumentException e) {
            ui.display("Wrong argument. Please write a number.");
            return false;
        }
    }

    public static boolean checkPositiveNumber(String number, int boardSize) {
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
