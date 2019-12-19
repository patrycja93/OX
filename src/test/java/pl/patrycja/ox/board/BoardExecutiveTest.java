package pl.patrycja.ox.board;

import org.testng.annotations.Test;
import pl.patrycja.ox.Sign;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardExecutiveTest {

    @Test
    public void putSignToBoardShouldReturnTrue() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Sign sign = Sign.CROSS;
        BoardExecutive boardExecutive = new BoardExecutive(number);

        //when
        boolean putSignToBoard = boardExecutive.putSignToBoard(fieldNumber, sign);

        //then
        assertTrue(putSignToBoard);
    }

    @Test
    public void putSignToBoardShouldReturnTruWhenFirstTryAndFalseWhenSecondTry() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Sign sign = Sign.CROSS;
        BoardExecutive boardExecutive = new BoardExecutive(number);

        //when
        boolean firstTry = boardExecutive.putSignToBoard(fieldNumber, sign);
        boolean secondTry = boardExecutive.putSignToBoard(fieldNumber, sign);

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }

}