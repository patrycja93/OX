package pl.patrycja.ox.winnerchecker;

import java.util.ArrayList;
import java.util.List;

class WinnerCheckerFactory {
    static List<WinnerChecker> getWinnerCheckers() {
        return new ArrayList<>() {{
            add(new WinnerCheckerHorizontal());
            add(new WinnerCheckerVertical());
            add(new WinnerCheckerDiagonalUp());
            add(new WinnerCheckerDiagonalDown());
        }};
    }
}
