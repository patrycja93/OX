package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

/**
 * A class can implement the Spectator interface when it
 * wants to observe the board.
 *
 * @author Patrycja Hyjek
 */

public interface Spectator {
    /**
     * This method is called whenever the board state was changed.
     *
     * @param fields is a list of fields which contains a sign
     * @param size is a size of the board
     * @param lastShot is a field's number in the board where the last sign was put
     */
    void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot);
    /**
     * This method is called when the game is end
     */
    void gameSummary();
}
