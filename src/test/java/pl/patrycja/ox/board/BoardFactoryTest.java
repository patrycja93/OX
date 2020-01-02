package pl.patrycja.ox.board;

import org.testng.annotations.Test;
import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BoardFactoryTest {

    @Test
    public void createBoardShouldCreateBoardExecutiveObject() {
        //given
        int size = 10;
        List<Spectator> spectators;
        GameSettings gameSettings = GameSettings.builder().build();
        spectators = SpectatorsRoom.addSpectators(gameSettings);

        //when
        Board board = BoardFactory.createBoard(10, spectators);

        //then
        assertTrue(board instanceof BoardExecutive);
    }

}