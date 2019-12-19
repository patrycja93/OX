package pl.patrycja.ox.board;

public class BoardFactory {

    public static Board boardCreator(){
        return new BoardExecutive();
    }
}
