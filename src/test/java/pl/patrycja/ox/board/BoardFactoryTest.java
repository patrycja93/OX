package pl.patrycja.ox.board;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BoardFactoryTest {

    @Test
    public void createBoardShouldCreateBoardExecutiveObject() {
        //given
        int size = 10;

        //when
        Board board = BoardFactory.createBoard(10);

        //then
        assertTrue(board instanceof BoardExecutive);
    }

}