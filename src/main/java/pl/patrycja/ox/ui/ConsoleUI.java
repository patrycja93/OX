package pl.patrycja.ox.ui;

import java.util.Scanner;

class ConsoleUI implements UI {

    @Override
    public void display(String input) {
        System.out.println(input);
    }

    @Override
    public Scanner read() {
        return new Scanner(System.in);
    }
}
