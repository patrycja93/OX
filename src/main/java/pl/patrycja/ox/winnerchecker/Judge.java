package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ScoreBoard;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Observe the Board class.
 * Make an operation after changes on the board.
 *
 * @author Patrycja
 */
public class Judge implements Spectator {

    private final JudgeStatements judgeStatements = new JudgeStatements();
    private GameSettings gameSettings;
    private UI ui;
    private ScoreBoard scoreBoard;
    private List<WinnerChecker> winnerCheckers;
    private boolean isMatchOver;
    private Map<Integer, Sign> moves = new HashMap<>();

    /**
     * Create Judge object.
     * Create the winner checkers.
     *
     * @param gameSettings the game settings
     * @param ui           kind of user interface
     * @param scoreBoard   the board with points of players
     */
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

    /**
     * Return information about the match is over.
     */
    public boolean isMatchOver() {
        return isMatchOver;
    }

    /**
     * Start new match.
     * Clear map of moves.
     *
     * @param number number of match
     * @param player player who has a move
     */
    public void newMatch(int number, Player player) {
        ui.display("match_number", number, player);
        moves.clear();
        isMatchOver = false;
    }

    /**
     * Display information about player has changed.
     *
     * @param player player who has a move
     */
    public void playerHasChanged(Player player) {
        if (!isMatchOver) {
            ui.display("player_move", player);
        }
    }

    /**
     * Return information about the game is over.
     *
     * @param players list of players
     */
    public void gameOver(List<Player> players) {
        ui.display("game_over");
        Statement winners = judgeStatements.checkWinners(players);
        boolean isDraw = winners.getArguments().size() == players.size();

        Function<List<Player>, List<String>> score = p -> p.stream()
                .map(player -> player + ": " + player.getPoints())
                .collect(Collectors.toList());

        if (isDraw) {
            Statement draw = new Statement("end_draw", players);
            List<String> apply = score.apply(draw.getArguments());
            String str = String.join(" ", apply);
            ui.display(draw.getMessage(), str);
        } else {
            Statement losers = judgeStatements.checkLosers(players);
            ui.display(winners.getMessage(), String.join(" " , score.apply(winners.getArguments())));
            ui.display(losers.getMessage(), String.join(" " , score.apply(losers.getArguments())));
        }
    }

    private boolean isWinner(Map<Integer, Sign> fields, int lastShot) {
        int playersNumber = 2;
        int minimumNumberOfSignsWhenWinnerCanExists =
                (gameSettings.getUnbrokenLine() * playersNumber) - 1;
        if (fields.size() >= minimumNumberOfSignsWhenWinnerCanExists) {
            return winnerCheckers.stream().anyMatch(winnerChecker ->
                    winnerChecker.checkingWinnerCondition(fields, lastShot));
        }
        return false;
    }

    private void state() {
        scoreBoard.addDrawPoints();
        showResult("draw");
    }

    private void state(Player player) {
        scoreBoard.addWinnerPoints(player);
        showResult("winner_is", player);
    }

    private void showResult(String message, Object... args) {
        List<Player> scores = scoreBoard.getResults();
        ui.display(message, args);
        scores.forEach(player -> ui.display("score", player, player.getPoints()));
        isMatchOver = true;
    }

    private void isDraw(int size) {
        if (size * size == moves.size()) {
            state();
        }
    }
}