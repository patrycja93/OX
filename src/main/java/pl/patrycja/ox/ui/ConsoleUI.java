package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void display(String input) {
        System.out.println(input);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
