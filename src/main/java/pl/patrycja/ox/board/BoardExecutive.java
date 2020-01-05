package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BoardExecutive implements Board {

    private int size;
    private Map<Integer, Sign> fields = new HashMap<>();
    private List<Spectator> spectators;

    BoardExecutive(int size, List<Spectator> spectators) {
        this.size = size;
        this.spectators = spectators;
    }

/*    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        int fullSize = size * size;
        int maxFieldNumberLength = getFieldNumberLength(fullSize);
        for (int i = 0; i < fullSize; i++) {
            if (!fields.containsKey(i)) {
                addSpace(maxFieldNumberLength - getFieldNumberLength(i + 1), board);
                int index = i + 1;
                board.append(index).append(" ");
            } else {
                Sign sign = fields.get(i);
                addSpace(maxFieldNumberLength - 1, board);
                board.append(sign).append(" ");
            }
            if ((i + 1) % Math.sqrt(fullSize) == 0) board.append("\n");
        }
        return board.toString();
    }*/

    @Override
    public boolean putSign(int fieldNumber, Sign sign) {
        int field = fieldNumber - 1;
        int maximumFieldNumber = size * size;
        if (field < 0 || field >= maximumFieldNumber) {
            informAboutOverstepRange(spectators);
            return false;
        } else {
            if (!fields.containsKey(field)) {
                fields.put(field, sign);
                informAboutPutSign(spectators, field, sign);
                return true;
            } else {
                informAboutPlaceIsBusy(spectators);
                return false;
            }
        }
    }

    @Override
    public void clean() {
        fields.clear();
    }

    @Override
    public void informAboutPutSign(List<Spectator> spectators, int field, Sign sign) {
        spectators.forEach(spectator -> spectator.putSignSuccess(field, sign));
    }

    @Override
    public void informAboutOverstepRange(List<Spectator> spectators) {
        spectators.forEach(Spectator::putSignFailureOverstepRange);
    }

    @Override
    public void informAboutPlaceIsBusy(List<Spectator> spectators) {
        spectators.forEach(Spectator::putSignFailurePlaceIsBusy);
    }

    @Override
    public void startMatch(List<Spectator> spectators, int number, Sign sign) {
        spectators.forEach(spectator -> spectator.newMatch(number, sign));
    }

/*    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }

    private void addSpace(Integer spaceNumber, StringBuilder board) {
        board.append(" ".repeat(Math.max(0, spaceNumber)));
    }*/
}