package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

/**
 * A class can implement the WinnerChecker interface when it
 * wants to check winner condition.
 *
 * @author Patrycja Hyjek
 */
interface WinnerChecker {
    /**
     * This method is called whenever the board state was changed.
     *
     * @param fields is a list of fields which contains a sign
     * @param lastShot is a field's number in the board where the last sign was put
     */
    boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot);
}
