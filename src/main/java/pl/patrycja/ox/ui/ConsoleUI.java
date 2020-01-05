package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

    private Scanner scanner;
    private InputChecker inputChecker = new InputChecker();

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display(Object input) {
        System.out.println(input);
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
