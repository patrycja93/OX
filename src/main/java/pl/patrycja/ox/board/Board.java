package pl.patrycja.ox.board;

public interface Board {

    Board createBoard(int size);

    void displayBoard();

    void putSignToBoard(Board board);
}
