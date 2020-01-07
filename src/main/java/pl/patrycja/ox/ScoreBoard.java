package pl.patrycja.ox;

import java.util.List;

/**
 * Give points to players.
 *
 * @author Patrycja
 */
public class ScoreBoard {

    private List<Player> playerList;
    private static final int POINTS_FOR_DRAW = 1;
    private static final int POINTS_FOR_WIN = 3;

    /**
     * Create ScoreBoard object with list of players.
     *
     * @param playerList list of players
     */
    public ScoreBoard(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void addWinnerPoints(Player player) {
        playerList.forEach(p -> {
            if (p.equals(player)) {
                p.addPoints(POINTS_FOR_WIN);
            }
        });
    }

    /**
     * Give points for draw to each player.
     */
    public void addDrawPoints() {
        playerList.forEach(p -> p.addPoints(POINTS_FOR_DRAW));
    }

    /**
     * Return list of players
     */
    public List<Player> getResults() {
        return playerList;
    }
}
