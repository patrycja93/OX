package pl.patrycja.ox;

public interface Board {

    Board createBoard(int size);
    void displayBoard();
    void putSignToBoard(Board board);
}
