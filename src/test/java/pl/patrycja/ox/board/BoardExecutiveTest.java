package pl.patrycja.ox.board;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.TestUI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardExecutiveTest {

    List<Spectator> spectators;

    @BeforeTest
    public void createSpectators() {
        GameSettings gameSettings = GameSettings
                .builder()
                .build();

        Spectators spectator = new Spectators(gameSettings, new TestUI());
        spectators = spectator.create();
    }

    @Test
    public void putSignToBoardShouldReturnTrue() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Sign sign = Sign.X;
        BoardExecutive boardExecutive = new BoardExecutive(number, spectators);

        //when
        boolean putSignToBoard = boardExecutive.putSign(fieldNumber, sign);

        //then
        assertTrue(putSignToBoard);
    }

    @Test
    public void putSignToBoardShouldReturnTruWhenFirstTryAndFalseWhenSecondTry() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Sign sign = Sign.X;
        BoardExecutive boardExecutive = new BoardExecutive(number, spectators);

        //when
        boolean firstTry = boardExecutive.putSign(fieldNumber, sign);
        boolean secondTry = boardExecutive.putSign(fieldNumber, sign);

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }

}