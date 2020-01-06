package pl.patrycja.ox;

import java.util.List;

public class ScoreBoard {

    private List<Player> playerList;
    private static final int POINTS_FOR_DRAW = 1;
    private static final int POINTS_FOR_WIN = 3;

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

    public void addDrawPoints() {
        playerList.forEach(p -> p.addPoints(POINTS_FOR_DRAW));
    }

    public List<Player> getResults() {
        return playerList;
    }
}
