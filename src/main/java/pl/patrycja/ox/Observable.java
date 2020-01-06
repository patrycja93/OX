package pl.patrycja.ox;

import pl.patrycja.ox.winnerchecker.Spectator;

/**
 * A class can implement the Observable interface when it
 * wants to be observe by spectators.
 *
 * @author Patrycja Hyjek
 */
public interface Observable {

    void notifySpectators(int field, Player player);

    void subscribe(Spectator spectator);
}
