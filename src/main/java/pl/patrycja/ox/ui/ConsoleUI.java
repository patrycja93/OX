package pl.patrycja.ox.ui;

import pl.patrycja.ox.Language;
import pl.patrycja.ox.Sign;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class ConsoleUI implements UI {

    private Scanner scanner;
    private InputChecker inputChecker;
    private String[] args;
    private ResourceBundle messages;

    public ConsoleUI(String[] args) {
        this.args = args;
        scanner = new Scanner(System.in);
        inputChecker = new InputChecker();
        checkInputParameters();
    }

    private void checkInputParameters() {
        if (inputChecker.checkIfInputParametersAreNotValid(args)) {
            displayError("Entered wrong arguments. "
                    + "Please run the game again with correct integer numbers.");
        }
        if (inputChecker.checkIfUnbrokenLineIsGraterThanBoardSize(args)) {
            displayWarning("Unbroken number of signs cannot be greater "
                    + "then board size and less than 3. Values was changed.\n");
        }
    }

    @Override
    public void display(String input) {
        System.out.println(messages.getString(input));
    }

    @Override
    public void display(Object input) {
        System.out.println(input);
    }

    @Override
    public void display(String message, Object... args) {
        System.out.println(String.format(messages.getString(message), args));
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public int readNumber() {
        String next = scanner.nextLine();
        while (!inputChecker.checkIfInteger(next)) {
            display("wrong_argument");
            next = scanner.nextLine();
        }
        return Integer.parseInt(next);
    }

    @Override
    public void getLanguage() {
        System.out.println("Choose language: en/pl ");
        String readLanguage = read().toUpperCase();

        while (!inputChecker.validateLanguageValue(readLanguage)) {
            System.out.println("Inappropriate language, "
                    + "please choose pl or en.");
            readLanguage = read().toUpperCase();
        }

        this.messages = ResourceBundle.getBundle("messages",
                new Locale(readLanguage,
                        Language.valueOf(readLanguage
                                .toUpperCase())
                                .getCountryCode()));
    }

    @Override
    public Sign getSign() {
        String sign = read();
        while (!inputChecker.validateSign(sign)) {
            display("inappropriate_sign");
            sign = read();
        }
        return Sign.valueOf(sign);
    }
}