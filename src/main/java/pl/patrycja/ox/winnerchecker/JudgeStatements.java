package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JudgeStatements {

    String showGameSummary(List<Player> players) {
        final int maxAmountOfPoints = getMaxAmountOfPoints(players);

        List<Player> winners = checkWinners(players, maxAmountOfPoints);
        List<Player> losers = checkLosers(players, maxAmountOfPoints);

        return buildStatement(players, winners, losers);
    }

    String buildStatement(List<Player> players, List<Player> winners, List<Player> losers) {
        String messageWinners = winners.size() > 1 ? "The winners are: " : "The winner is: ";

        String messageLosers = losers.size() == 1 ? "The loser is: " : "The loser are: ";

        String drawMessage = "Draw: ";

        StringBuilder statement = new StringBuilder("\nThe game is over!\n");
        if (winners.size() == players.size()) {
            appendToStatement(players, drawMessage, statement);
        } else {
            appendToStatement(winners, messageWinners, statement);
            statement.append("\n");
            appendToStatement(losers, messageLosers, statement);
        }
        return statement.toString();
    }

    void appendToStatement(List<Player> players, String message, StringBuilder statement) {
        statement.append(message);
        players.forEach(player -> statement.append(player).append(":").append(player.getPoints()).append(" "));
    }

    List<Player> checkLosers(List<Player> players, int maxAmountOfPoints) {
        return players.stream()
                .filter(player -> player.getPoints() < maxAmountOfPoints)
                .collect(Collectors.toList());
    }

    List<Player> checkWinners(List<Player> players, int maxAmountOfPoints) {
        return players.stream()
                .filter(player -> player.getPoints() == maxAmountOfPoints)
                .collect(Collectors.toList());
    }

    int getMaxAmountOfPoints(List<Player> players) {
        return players.stream()
                .max(Comparator.comparingInt(Player::getPoints))
                .map(Player::getPoints)
                .orElse(0);
    }
}