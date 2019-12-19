package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Sign;

import java.util.Map;

public class Judge implements Spectators {

    int unbrokenLineSign = 2;

    @Override
    public void subscribe(Map<Integer, Sign> fields, int size, int lastShoot) {
        /*
        check if winner -> if false do nothing else change round show score
         */
        checkHorizontal(fields, size, lastShoot);
    }

    boolean checkHorizontal(Map<Integer, Sign> fields, int size, int lastShoot){
        int counter = 0;

        return true;
    }

}
