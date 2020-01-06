package pl.patrycja.ox.ui;

import pl.patrycja.ox.Language;
import pl.patrycja.ox.Sign;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class FileUI implements UI {

    private Scanner scanner;
    private BufferedWriter bufferedWriter;
    private String[] args;
    private InputChecker inputChecker = new InputChecker();
    private ResourceBundle messages;

    public FileUI(String[] args) {
        this.args = args;
        validateInputParameters();
        generateSequenceForAutomaticTests();
        setScannerAndWriter();
    }

    private void validateInputParameters() {
        if (inputChecker.checkIfInputParametersAreNotValid(args)) {
            displayError("Entered wrong arguments. Please run the game again with correct integer numbers.");
        }
        if (inputChecker.checkIfUnbrokenLineIsGraterThanBoardSize(args)) {
            displayWarning("Unbroken number of signs cannot be greater then board size and less than 3. Values was changed.\n");
        }
    }

    private void generateSequenceForAutomaticTests() {
        Sequence sequence = new Sequence(args);
        sequence.generateSequence();
    }

    private void setScannerAndWriter() {
        try {
            scanner = new Scanner(new File("src/main/resources/pl/patrycja/ox/ui/test_sequence.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/pl/patrycja/ox/ui/test_out.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display(String input) {
        writeToFile(messages.getString(input));
    }

    @Override
    public void display(Object input) {
        writeToFile(input);
    }

    @Override
    public void display(String message, Object... args) {
        writeToFile(String.format(messages.getString(message), args));
    }

    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public int readNumber() {
        String next = scanner.next();
        return Integer.parseInt(next);
    }

    @Override
    public void getLanguage() {
        this.messages = ResourceBundle.getBundle("messages", new Locale(Language.EN.name().toLowerCase(),
                Language.EN.getCountryCode()));
    }

    @Override
    public Sign getSign() {
        return Sign.valueOf(scanner.next());
    }

    private void writeToFile(Object input) {
        try {
            bufferedWriter.write(input.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
