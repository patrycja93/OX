package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;

/**
 * Observes changes on the board.
 *
 * @author Patrycja Hyjek
 */

public interface Spectator {
    /**
     * //TODO: add doc
     */
    void signWasPut(int field, Player player);
}
