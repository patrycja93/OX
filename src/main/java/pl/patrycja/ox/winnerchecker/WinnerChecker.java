package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

interface WinnerChecker {

    boolean checkingWinnerCondition(Map<Integer, Sign> fields, int lastShot);
}
