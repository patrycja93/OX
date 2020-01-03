package pl.patrycja.ox.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileUI implements UI {

    private Scanner scanner;
    private BufferedWriter bufferedWriter;

    public FileUI() {
        try {
            this.scanner = new Scanner(new File("src/main/resources/pl/patrycja/ox/ui/test_sequence.txt"));
            this.bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/pl/patrycja/ox/ui/test_out.txt"));
            this.scanner.useDelimiter(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display(Object input) {
        writeToFile(input);
    }

    private void writeToFile(Object input) {
        try {
            bufferedWriter.write(input.toString());
            bufferedWriter.append("\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
