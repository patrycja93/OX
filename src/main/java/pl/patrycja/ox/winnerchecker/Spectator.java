package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

public interface Spectator {

    void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot);

    void matchSummary();
}
