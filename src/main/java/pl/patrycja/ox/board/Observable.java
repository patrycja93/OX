package pl.patrycja.ox.board;

import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.List;

public interface Observable {

    void inform(List<Spectators> spectators);
}
