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
            this.scanner = new Scanner(new File(getClass()
                    .getResource("test_sequence.txt").getPath()));
            this.bufferedWriter = new BufferedWriter(new FileWriter(new File(getClass()
                    .getResource("test_out.txt").getPath())));
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
