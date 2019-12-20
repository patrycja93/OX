package pl.patrycja.ox;

import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;

public interface Observable {

    void inform(List<Spectator> spectators);
}
