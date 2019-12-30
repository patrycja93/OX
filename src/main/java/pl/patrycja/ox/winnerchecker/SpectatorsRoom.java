package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * A class created new spectator.
 *
 * @author Patrycja Hyjek
 */
public class SpectatorsRoom {

    /**
     * This method adds and returns a list of spectators
     *
     * @param gameSettings is an object with game's settings.
     */
    public static List<Spectator> addSpectators(GameSettings gameSettings) {
        return new ArrayList<>() {{
            add(new Judge(gameSettings));
        }};
    }
}
