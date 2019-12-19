package pl.patrycja.ox;

public class Main {
    public static void main(String[] args) {

        Board board = new BoardExecutive();
        board.createBoard(6).displayBoard();
    }
}
