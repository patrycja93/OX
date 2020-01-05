package pl.patrycja.ox;

/**
 * A class can implement the Observable interface when it
 * wants to be observe by spectators.
 *
 * @author Patrycja Hyjek
 */
public interface Observable {
    /**
     * Notify about start of the match.
     *
     * @param number is number of match
     * @param player initial player
     */

    void startMatch(int number, Player player);

}
