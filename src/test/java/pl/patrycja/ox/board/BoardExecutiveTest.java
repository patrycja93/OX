package pl.patrycja.ox.board;

import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.PutSignStatus;
import pl.patrycja.ox.Sign;

import static org.testng.Assert.assertEquals;

public class BoardExecutiveTest {

    @Test
    public void putSignToBoardShouldReturnSuccess() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(number);

        //when
        PutSignStatus putSignToBoard = boardExecutive.putSign(fieldNumber, player);

        //then
        assertEquals(putSignToBoard, PutSignStatus.SUCCESS);
    }

    //TODO: correct this case
   /* @Test
    public void putSignToBoardShouldReturnTruWhenFirstTryAndFalseWhenSecondTry() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(number);

        //when
        boolean firstTry = boardExecutive.putSign(fieldNumber, player);
        boolean secondTry = boardExecutive.putSign(fieldNumber, player);

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }*/
}