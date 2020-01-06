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

    public boolean validateSign(String sign) {
        return Arrays.toString(Sign.values()).contains(sign);
    }

    public boolean validateLanguageValue(String language) {
        return Arrays.toString(Language.values()).contains(language);
    }
}
