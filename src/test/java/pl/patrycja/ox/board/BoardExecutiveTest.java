package pl.patrycja.ox.board;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.PutSignStatus;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Judge;

import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class BoardExecutiveTest {

    Judge judge = Mockito.mock(Judge.class);

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

    @Test
    public void putSignToBoardShouldReturnSuccessWhenFirstTryAndFailurePlaceOccupiedWhenSecondTry() {
        //given
        int size = 10;
        int fieldNumber = 4;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        PutSignStatus firstTry = boardExecutive.putSign(fieldNumber, player);
        PutSignStatus secondTry = boardExecutive.putSign(fieldNumber, player);

        //then
        assertEquals(PutSignStatus.SUCCESS, firstTry);
        assertEquals(PutSignStatus.FAILURE_PLACE_OCCUPIED, secondTry);
    }

    @Test
    public void putSignToBoardShouldReturnFailureRangeOver() {
        //given
        int size = 10;
        int fieldNumber = 102;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        PutSignStatus secondTry = boardExecutive.putSign(fieldNumber, player);

        //then
        assertEquals(PutSignStatus.FAILURE_RANGE_OVER, secondTry);
    }

    @Test
    public void subscribeShouldAddNewSubscriberToList() {
        //given
        int size = 10;
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.subscribe(judge);

        //then
        assertEquals(1, boardExecutive.getSpectators().size());
    }

    @Test
    public void notifySpectatorsShouldRunMethodOnSpectators() {
        //given
        int size = 10;
        int field = 5;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.subscribe(judge);
        boardExecutive.notifySpectators(field, player);

        //then
        verify(judge).signWasPut(field, player);
    }

    @Test
    public void cleanShouldDeleteAllFields() {
        //given
        int size = 10;
        int field = 5;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.putSign(field, player);
        boardExecutive.clean();

        //then
        assertEquals(0, boardExecutive.getFields().size());
    }
}