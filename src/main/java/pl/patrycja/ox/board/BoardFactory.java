package pl.patrycja.ox.board;

/**
 * A class BoardFactory create and return a new board.
 *
 * @author Patrycja Hyjek
 */

public class BoardFactory {
    /**
     * This method is called whenever we want to add a sign to the board.
     *
     * @param size is a board size.
     */
    public static Board createBoard(int size) {
        return new BoardExecutive(size);
    }
}
