package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

public interface Spectators {

    void subscribe(Map<Integer, Sign> fields, int size, int lastShot);
}
