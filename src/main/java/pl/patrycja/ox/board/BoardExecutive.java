package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BoardExecutive implements Board {

    private int size;
    private Map<Integer, Sign> fields = new HashMap<>();
    private int lastShot;
    private List<Spectator> spectators;

    BoardExecutive(int size, List<Spectator> spectators) {
        this.size = size;
        this.spectators = spectators;
    }

    @Override
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
    }

    @Override
    public boolean putSignToBoard(int fieldNumber, Sign sign) {
        if (!fields.containsKey(fieldNumber - 1)) {
            fields.put(fieldNumber - 1, sign);
            lastShot = fieldNumber - 1;
            inform(spectators);
            return true;
        } else {
            return false;
        }
        //TODO: add condition fieldNumber is not in range and inform spectators
        //TODO: success put sign to board or not
    }

    @Override
    public void clean() {
        fields.clear();
    }

    @Override
    public void inform(List<Spectator> spectators) {
        spectators.forEach(spectator -> spectator.lookAtBoard(fields, size, lastShot));
    }

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }

    private void addSpace(Integer spaceNumber, StringBuilder board) {
        board.append(" ".repeat(Math.max(0, spaceNumber)));
    }
}
