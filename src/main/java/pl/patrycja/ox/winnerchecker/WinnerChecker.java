package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

public interface WinnerChecker {

    boolean checkingWinnerCondition(Map<Integer, Sign> fields, int size, int lastShot, int unbrokenLine);
}
