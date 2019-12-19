package pl.patrycja.ox.ui;

public class ConsoleUI implements UI {
    @Override
    public void display(String input) {
        System.out.println(input);
    }
}
