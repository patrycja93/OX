package pl.patrycja.ox.board;

import org.testng.annotations.Test;
import pl.patrycja.ox.*;
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
        ScoreBoard scoreBoard = new ScoreBoard(getPlayers());
        Spectators spectator = new Spectators(gameSettings, new TestUI(), scoreBoard);
        List<Spectator> spectators = spectator.create();

        //when
        Board board = BoardFactory.createBoard(10, spectators);

        //then
        assertTrue(board instanceof BoardExecutive);
    }

    private List<Player> getPlayers() {
        return List.of(new Player("A", Sign.X), new Player("B", Sign.O));
    }

}