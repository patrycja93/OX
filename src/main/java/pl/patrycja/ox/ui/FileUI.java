package pl.patrycja.ox.ui;

import java.io.*;
import java.util.Scanner;

class FileUI implements UI {

    private String fileIn = "src/main/resources/pl/patrycja/ox/ui/test_in.txt";
    private String fileOut = "src/main/resources/pl/patrycja/ox/ui/test_out.txt";
    private Scanner scanner;
    private BufferedWriter bufferedWriter;

    public FileUI() {
        try {
            this.scanner = new Scanner(new File(fileIn));
            this.bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
            this.scanner.useDelimiter(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display(Object input) {
        try {
            this.bufferedWriter.write(input.toString());
            this.bufferedWriter.append("\n");
            this.bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
