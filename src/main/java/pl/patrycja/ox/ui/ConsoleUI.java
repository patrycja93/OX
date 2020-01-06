package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

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
            displayWarning("Unbroken number of signs cannot be greater then board size and less than 3. Values was changed.\n");
        }
    }

    @Override
    public void display(Object input) {
        System.out.println(input);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public int readNumber() {
        String next = scanner.nextLine();
        while (!inputChecker.checkIfInteger(next)) {
            display("Wrong argument. Please enter integer number.");
            next = scanner.nextLine();
        }
        return Integer.parseInt(next);
    }
}
