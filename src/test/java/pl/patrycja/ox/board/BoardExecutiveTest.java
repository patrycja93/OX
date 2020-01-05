package pl.patrycja.ox.board;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.patrycja.ox.*;
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

        ScoreBoard scoreBoard = new ScoreBoard(getPlayers());
        Spectators spectator = new Spectators(gameSettings, new TestUI(), scoreBoard);
        spectators = spectator.create();
    }

    @Test
    public void putSignToBoardShouldReturnTrue() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(number, spectators);

        //when
        boolean putSignToBoard = boardExecutive.putSign(fieldNumber, player);

        //then
        assertTrue(putSignToBoard);
    }

    @Test
    public void putSignToBoardShouldReturnTruWhenFirstTryAndFalseWhenSecondTry() {
        //given
        int number = 1000;
        int fieldNumber = 4;
        Player player = new Player("A", Sign.X);
        BoardExecutive boardExecutive = new BoardExecutive(number, spectators);

        //when
        boolean firstTry = boardExecutive.putSign(fieldNumber, player);
        boolean secondTry = boardExecutive.putSign(fieldNumber, player);

        //then
        assertTrue(firstTry);
        assertFalse(secondTry);
    }

    private List<Player> getPlayers() {
        return List.of(new Player("A", Sign.X), new Player("B", Sign.O));
    }
}