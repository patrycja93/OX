package pl.patrycja.ox.ui;

import pl.patrycja.ox.Language;
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

    public boolean checkIfInputParametersAreNotValid(String[] parameters) {
        try {
            for (String p : parameters) {
                Integer.parseInt(String.valueOf(p));
            }
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public boolean checkIfUnbrokenLineIsGraterThanBoardSize(String[] parameters) {
        if (parameters.length > 1) {
            int defaultValue = 3;
            String boardSize = String.valueOf(Math.max(Integer.parseInt(parameters[0]), defaultValue));
            String unbrokenLine = String.valueOf(Math.max(Integer.parseInt(parameters[1]), defaultValue));
            parameters[0] = boardSize;
            parameters[1] = unbrokenLine;

            if ((Integer.parseInt(parameters[0]) < Integer.parseInt(parameters[1]))) {
                parameters[0] = unbrokenLine;
                parameters[1] = boardSize;
                return true;
            }
        }
        return false;
    }

    public boolean checkIfInteger(String number) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Sign validateSign(String sign) {
        while (!Arrays.toString(Sign.values()).contains(sign)) {
            ui.display("inappropriate_sign");
            sign = ui.read();
        }
        return Sign.valueOf(sign);
    }

    public Language validateLanguageValue(String language) {
        language = language.toUpperCase();
        while (!Arrays.toString(Language.values()).contains(language)) {
            System.out.println("Inappropriate language, please choose pl or en.");
            language = ui.read();
        }
        return Language.valueOf(language);
    }

}
