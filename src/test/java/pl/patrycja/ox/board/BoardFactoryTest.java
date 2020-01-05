package pl.patrycja.ox.board;

import org.testng.annotations.Test;
import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.TestUI;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.Spectators;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BoardFactoryTest {

    @Test
    public void createBoardShouldCreateBoardExecutiveObject() {
        //given
        int size = 10;
        GameSettings gameSettings = GameSettings.builder().build();
        Spectators spectator = new Spectators(gameSettings, new TestUI());
        List<Spectator> spectators = spectator.create();

        //when
        Board board = BoardFactory.createBoard(10, spectators);

        //then
        assertTrue(board instanceof BoardExecutive);
    }

}