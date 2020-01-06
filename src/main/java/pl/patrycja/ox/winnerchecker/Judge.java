package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ScoreBoard;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Judge implements Spectator {

    private final JudgeStatements judgeStatements = new JudgeStatements();
    private GameSettings gameSettings;
    private UI ui;
    private ScoreBoard scoreBoard;
    private List<WinnerChecker> winnerCheckers;
    private boolean isMatchOver;
    private Map<Integer, Sign> moves = new HashMap<>();

    public Judge(GameSettings gameSettings, UI ui, ScoreBoard scoreBoard) {
        this.ui = ui;
        this.gameSettings = gameSettings;
        this.scoreBoard = scoreBoard;
        this.winnerCheckers = WinnerCheckerFactory.getWinnerCheckers(gameSettings);
    }

    @Override
    public void signWasPut(int field, Player player) {
        int reducedFieldNumber = field - 1;
        moves.put(reducedFieldNumber, player.getSign());

        if (isWinner(moves, reducedFieldNumber)) {
            state(player);
        } else {
            isDraw(gameSettings.getBoardSize());
        }
    }

    public boolean isMatchOver() {
        return isMatchOver;
    }

    public void newMatch(int number, Player player) {
        ui.display("Match number " + number + "\n" + player + " starts.\n");
        moves.clear();
        isMatchOver = false;
    }

    public void playerHasChanged(Player player) {
        if (!isMatchOver) {
            ui.display(player + " move.\n");
        }
    }

    public void gameOver(List<Player> players) {
        ui.display(judgeStatements.showGameSummary(players));
    }

    private boolean isWinner(Map<Integer, Sign> fields, int lastShot) {
        int playersNumber = 2;
        int minimumNumberOfSignsWhenWinnerCanExists = (gameSettings.getUnbrokenLine() * playersNumber) - 1;
        if (fields.size() >= minimumNumberOfSignsWhenWinnerCanExists) {
            return winnerCheckers.stream().anyMatch(winnerChecker -> winnerChecker.checkingWinnerCondition(fields, lastShot));
        }
        return false;
    }

    private void state() {
        scoreBoard.addDrawPoints();
        showResult("Draw!\n");
    }

    private void state(Player player) {
        scoreBoard.addWinnerPoints(player);
        showResult("Winner is " + player + ".\n");
    }

    private void showResult(String message) {
        List<Player> scores = scoreBoard.getResults();
        ui.display(message);
        scores.forEach(player -> ui.display(player + ":" + player.getPoints() + " "));
        isMatchOver = true;
    }

    private void isDraw(int size) {
        if (size * size == moves.size()) {
            state();
        }
    }
}