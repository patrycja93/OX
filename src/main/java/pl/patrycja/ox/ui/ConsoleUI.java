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
        String next = scanner.nextLine();
        while (!inputChecker.checkIfInteger(next)) {
            display("Wrong argument. Please enter integer number.");
            next = scanner.nextLine();
        }
        return Integer.parseInt(next);
    }

    private boolean invalid(String next) {
        try {
            Integer.parseInt(next);
            return true;
        } catch (NumberFormatException e) {
            display("Wrong argument. Please enter integer number.");
            return false;
        }
    }
}
