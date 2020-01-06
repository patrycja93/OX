package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Scanner scanner;
    private InputChecker inputChecker = new InputChecker();
    private String[] args;

    public ConsoleUI(String[] args) {
        this.args = args;
        scanner = new Scanner(System.in);
        checkInputParameters();
    }

    private void checkInputParameters() {
        if (!inputChecker.checkIfInputParametersAreValid(args)) {
            displayError("Entered wrong arguments. Please run the game again with correct integer numbers.");
        }
        if (inputChecker.checkIfUnbrokenLineIsGraterThanBoardSize(args)) {
            displayError("Unbroken number of sign cannot be greater then board size and less than 3. Values was changed.\n");
        }
    }

    @Override
    public void display(Object input) {
        System.out.println(input);
    }

    @Override
    public void displayBoard(Object board) {
        String o = ANSI_CYAN + "O" + ANSI_RESET;
        String x = ANSI_YELLOW + "X" + ANSI_RESET;

        board = board.toString().replace("O", o).replace("X", x);

        System.out.println(board);
    }

    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public int readNumber() {
        scanner.useDelimiter("\n");
        String next = scanner.next();
        while (!inputChecker.checkIfInteger(next)) {
            display("Wrong argument. Please enter integer number.");
            next = scanner.next();
        }
        return Integer.parseInt(next);
    }
}
