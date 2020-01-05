package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

/**
 * Observes changes on the board.
 *
 * @author Patrycja Hyjek
 */

public interface Spectator {
    /**
     * This method is called whenever the board state was changed.
     *
     */
    void putSignSuccess(int field, Sign sign);

    void putSignFailureOverstepRange();

    void putSignFailurePlaceIsBusy();

    /**
     * Returns information if match is over.
     */
    boolean isMatchOver();

    void newMatch(int number, Sign sign);
}
