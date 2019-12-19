package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BoardExecutive implements Board {

    private int size;
    private Map<Integer, Sign> fields = new HashMap<>();
    private int lastShoot;

    BoardExecutive(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        int fullSize = size * size;
        int maxFieldNumberLength = getFieldNumberLength(fullSize);
        for (int i = 0; i < fullSize; i++) {
            int amountOfSpace = maxFieldNumberLength - getFieldNumberLength(i + 1);
            while (amountOfSpace > 0) {
                board.append(" ");
                amountOfSpace = amountOfSpace - 1;
            }
            if (!fields.containsKey(i)) {
                int index = i + 1;
                board.append(index).append(" ");
            } else {
                Sign sign = fields.get(i);
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
            lastShoot = fieldNumber - 1;
            return true;
        } else {
            return false;
        }
    }

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }

    @Override
    public void inform(List<Spectators> spectators) {
        spectators.forEach(spectator -> spectator.subscribe(fields, size, lastShoot));
    }
}
