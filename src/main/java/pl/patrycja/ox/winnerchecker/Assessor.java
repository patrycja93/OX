package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.HashMap;
import java.util.Map;

class Assessor implements Spectator {

    private UI ui;
    private GameSettings gameSettings;
    private Map<Integer, Sign> moves;

    Assessor(GameSettings gameSettings, UI ui) {
        this.moves = new HashMap<>();
        this.ui = ui;
        this.gameSettings = gameSettings;
    }

    @Override
    public void putSignSuccess(int field, Player player) {
        int reducedFieldNumber = field - 1;
        moves.put(reducedFieldNumber, player.getSign());
        ui.display("Player " + player.getName() + "(" + player.getSign() + ") put sign to " + field + ".");
        ui.display(board());
    }

    @Override
    public void putSignFailureOverstepRange() {
        ui.display(board());
    }

    @Override
    public void putSignFailurePlaceIsBusy() {
        ui.display(board());
    }

    @Override
    public boolean isMatchOver() {
        return false;
    }

    @Override
    public void newMatch(int number, Player player) {
        moves.clear();
        ui.display(board());
    }

    @Override
    public void playerHasChanged(Player player) {
        //TODO: implements this method
    }

    private String board() {
        StringBuilder board = new StringBuilder();
        int boardSize = gameSettings.getBoardSize();
        int fullSize = boardSize * boardSize;
        int maxFieldNumberLength = getFieldNumberLength(fullSize);
        for (int i = 0; i < fullSize; i++) {
            if (!moves.containsKey(i)) {
                addSpace(maxFieldNumberLength - getFieldNumberLength(i + 1), board);
                int index = i + 1;
                board.append(index).append(" ");
            } else {
                Sign sign = moves.get(i);
                addSpace(maxFieldNumberLength - 1, board);
                board.append(sign).append(" ");
            }
            if ((i + 1) % Math.sqrt(fullSize) == 0) board.append("\n");
        }
        return board.toString();
    }

    private int getFieldNumberLength(Integer i) {
        return String.valueOf(i).length();
    }

    private void addSpace(Integer spaceNumber, StringBuilder board) {
        board.append(" ".repeat(Math.max(0, spaceNumber)));
    }
}