package pl.patrycja.ox.board;

import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.List;

/**
 * Create and return a new board.
 *
 * @author Patrycja Hyjek
 */

public class BoardFactory {
    /**
     * Called whenever we want to add a sign to the board.
     *
     * @param size is a board size.
     */
    public static Board createBoard(int size, List<Spectator> spectators) {
        return new BoardExecutive(size, spectators);
    }
}
