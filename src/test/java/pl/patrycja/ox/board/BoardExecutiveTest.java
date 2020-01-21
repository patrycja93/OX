package pl.patrycja.ox.board;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.PutSignStatus;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.winnerchecker.Judge;

import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class BoardExecutiveTest {

    private Judge judge;
    private final Player player = new Player("A", Sign.X);
    private final int size = 10;
    private final int fieldNumber = 4;

    @BeforeMethod
    public void createMock() {
        judge = Mockito.mock(Judge.class);
    }

    @Test
    public void putSignToBoardShouldReturnSuccess() {
        //given
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        PutSignStatus putSignToBoard = boardExecutive.putSign(fieldNumber, player);

        //then
        assertEquals(putSignToBoard, PutSignStatus.FAILURE_PLACE_OCCUPIED);
    }

    @Test
    public void putSignToBoardShouldReturnSuccessWhenFirstTryAndFailurePlaceOccupiedWhenSecondTry() {
        //given
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
        int tooMuchFieldNumber = 123;
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        PutSignStatus putSignStatus = boardExecutive.putSign(tooMuchFieldNumber, player);

        //then
        assertEquals(PutSignStatus.FAILURE_RANGE_OVER, putSignStatus);
    }

    @Test
    public void subscribeShouldAddNewSubscriberToList() {
        //given
        int expectedNumberOfSpectators = 1;
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.subscribe(judge);

        //then
        assertEquals(boardExecutive.getSpectators().size(), expectedNumberOfSpectators);
    }

    @Test
    public void notifySpectatorsShouldRunMethodOnSpectators() {
        //given
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.subscribe(judge);
        boardExecutive.notifySpectators(fieldNumber, player);

        //then
        verify(judge).signWasPut(fieldNumber, player);
    }

    @Test
    public void cleanShouldDeleteAllFields() {
        //given
        int expectedFieldsSize = 0;
        BoardExecutive boardExecutive = new BoardExecutive(size);

        //when
        boardExecutive.putSign(fieldNumber, player);
        boardExecutive.clean();

        //then
        assertEquals(boardExecutive.getFields().size(), expectedFieldsSize);
    }
}