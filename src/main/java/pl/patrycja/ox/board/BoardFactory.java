package pl.patrycja.ox.board;

public class BoardFactory {

    public static Board createBoard(int size){
        return new BoardExecutive(size);
    }
}
