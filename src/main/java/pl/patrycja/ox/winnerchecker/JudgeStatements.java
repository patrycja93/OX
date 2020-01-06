package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JudgeStatements {

    Statement checkLosers(List<Player> players) {
        int maxAmountOfPoints = getMaxAmountOfPoints(players);
        List<Player> playersList = players.stream()
                .filter(player -> player.getPoints() < maxAmountOfPoints)
                .collect(Collectors.toList());

        String messageLosers = playersList.size() == 1 ? "loser_is" : "losers_are";

        return new Statement(messageLosers, playersList);
    }

    Statement checkWinners(List<Player> players) {
        int maxAmountOfPoints = getMaxAmountOfPoints(players);
        List<Player> playersList = players.stream()
                .filter(player -> player.getPoints() == maxAmountOfPoints)
                .collect(Collectors.toList());

        String messageWinners = playersList.size() > 1 ? "winners_are" : "winner_is";

        return new Statement(messageWinners, playersList);
    }

    int getMaxAmountOfPoints(List<Player> players) {
        return players.stream()
                .max(Comparator.comparingInt(Player::getPoints))
                .map(Player::getPoints)
                .orElse(0);
    }
}