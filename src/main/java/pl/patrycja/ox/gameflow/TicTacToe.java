package pl.patrycja.ox.gameflow;

/**
 * A class TicTacToe presents a main class.
 *
 * @author Patrycja Hyjek
 */
class TicTacToe {

    /**
     * This method is called whenever we start a new game.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
