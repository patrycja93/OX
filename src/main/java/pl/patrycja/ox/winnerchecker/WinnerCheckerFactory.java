package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;

import java.util.List;

class WinnerCheckerFactory {
    static List<WinnerChecker> getWinnerCheckers(GameSettings gameSettings) {
        return List.of(
                new WinnerCheckerHorizontal(gameSettings),
                new WinnerCheckerVertical(gameSettings),
                new WinnerCheckerDiagonalUp(gameSettings),
                new WinnerCheckerDiagonalDown(gameSettings)
        );
    }
}
