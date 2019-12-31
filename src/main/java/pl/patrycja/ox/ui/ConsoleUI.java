package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

    private Scanner scanner;

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
}
