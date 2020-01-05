package pl.patrycja.ox.board;

import pl.patrycja.ox.Player;
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

    @Override
    public boolean putSign(int fieldNumber, Player player) {
        int reducedFieldNumber = fieldNumber - 1;
        int maximumFieldNumber = size * size;
        if (fieldNumber < 1 || fieldNumber > maximumFieldNumber) {
            informAboutOverstepRange(spectators);
            return false;
        } else {
            if (!fields.containsKey(reducedFieldNumber)) {
                fields.put(reducedFieldNumber, player.getSign());
                informAboutPutSign(spectators, fieldNumber, player);
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
    public void startMatch(List<Spectator> spectators, int number, Player player) {
        spectators.forEach(spectator -> spectator.newMatch(number, player));
    }

    private void informAboutPutSign(List<Spectator> spectators, int field, Player player) {
        spectators.forEach(spectator -> spectator.putSignSuccess(field, player));
    }

    private void informAboutOverstepRange(List<Spectator> spectators) {
        spectators.forEach(Spectator::putSignFailureOverstepRange);
    }

    private void informAboutPlaceIsBusy(List<Spectator> spectators) {
        spectators.forEach(Spectator::putSignFailurePlaceIsBusy);
    }
}