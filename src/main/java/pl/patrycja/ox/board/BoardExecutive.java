package pl.patrycja.ox.board;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.PutSignStatus;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Spectator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.patrycja.ox.PutSignStatus.*;


public class BoardExecutive implements Board {

    private int size;
    private Map<Integer, Sign> fields = new HashMap<>();
    private List<Spectator> spectators = new ArrayList<>();

    public BoardExecutive(int size) {
        this.size = size;
    }

    @Override
    public PutSignStatus putSign(int fieldNumber, Player player) {
        int reducedFieldNumber = fieldNumber - 1;
        int maximumFieldNumber = size * size;
        if (fieldNumber < 1 || fieldNumber > maximumFieldNumber) {
            return FAILURE_RANGE_OVER;
        } else {
            if (!fields.containsKey(reducedFieldNumber)) {
                fields.put(reducedFieldNumber, player.getSign());
                return SUCCESS;
            } else {
                return FAILURE_PLACE_OCCUPIED;
            }
        }
    }

    @Override
    public void clean() {
        fields.clear();
    }

    @Override
    public void notifySpectators(int field, Player player) {
        spectators.forEach(spectator -> spectator.signWasPut(field, player));
    }

    @Override
    public void subscribe(Spectator spectator) {
        spectators.add(spectator);
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder("\n");
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
            if ((i + 1) % Math.sqrt(fullSize) == 0) {
                board.append("\n");
            }
        }
        return board.toString();
    }

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }

    private void addSpace(Integer spaceNumber, StringBuilder board) {
        board.append(" ".repeat(Math.max(0, spaceNumber)));
    }

    List<Spectator> getSpectators() {
        return spectators;
    }
}