package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;

/**
 * Observes changes on the board.
 *
 * @author Patrycja Hyjek
 */

public interface Spectator {
    /**
     * Information about sign was put to board.
     *
     * @param field  field in board where sign was put
     * @param player which player put the sign
     */
    void signWasPut(int field, Player player);
}
