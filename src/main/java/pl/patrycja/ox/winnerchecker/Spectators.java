package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.board.Board;

import java.util.Map;

public interface Spectators {

    void lookAtBoard(Map<Integer, Sign> fields, int size, int lastShot);

    void matchFinished();

}
