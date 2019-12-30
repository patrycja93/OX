package pl.patrycja.ox;

import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;

/**
 * A class can implement the Observable interface when it
 * wants to be observe by spectators.
 *
 * @author Patrycja Hyjek
 */
public interface Observable {
    /**
     * This method is called whenever the observable wants to inform spectators about changes.
     *
     * @param spectators is a list of objects which are spectators
     */
    void inform(List<Spectator> spectators);
}
