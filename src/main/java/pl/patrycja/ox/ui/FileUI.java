package pl.patrycja.ox.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileUI implements UI {

    private String fileIn = "src/main/resources/pl/patrycja/ox/ui/test_in.txt";
    private String fileOut = "src/main/resources/pl/patrycja/ox/ui/test_out.txt";
    private String fileSequence = "src/main/resources/pl/patrycja/ox/ui/test_sequence.txt";
    private Scanner scanner;

    public FileUI() {
        try {
            this.scanner = new Scanner(new File(fileIn));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display(Object input) {
        writeToFile(input, fileOut);
    }

    private void writeToFile(Object input, String pathToFile) {
        File file = new File(pathToFile);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
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

    public void generateSequence(int size, int unbrokenLine, int towards) {
        switch (towards) {
            case '0': {
                generateHorizontalSequence(size, unbrokenLine);
            }
            case '1': {
                generateVerticalSequence(size, unbrokenLine);
            }
        }
    }

    private void generateHorizontalSequence(int size, int unbrokenLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X ");
        for (int i = 0; i < size * size; i++) {
            int row = i / size;
            if (i + unbrokenLine > (size * (row + 1))) {
                continue;
            }
            for (int j = 0; j < unbrokenLine; j++) {
                stringBuilder.append(i + j + 1).append(" ");
                if (i + j + size < size * size) {
                    stringBuilder.append(i + j + size + 1).append(" ");
                } else {
                    stringBuilder.append((i + j - size) + 1).append(" ");
                }
            }
        }
        writeToFile(stringBuilder.deleteCharAt(stringBuilder.length() - 1), fileSequence);
    }

    private void generateVerticalSequence(int size, int unbrokenLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X ");
        for (int i = 0; i < size * size; i++) {
            int column = i % size;
            if ((i + (unbrokenLine - 1) * size) > (size * size) - (size - column)) {
                continue;
            }
            for (int j = 0; j < unbrokenLine; j++) {
                stringBuilder.append((i + (j * size)) + 1).append(" ");
                if (column < size - 1) {
                    stringBuilder.append((i + (j * size)) + 1 + 1).append(" ");
                } else {
                    stringBuilder.append(i + (j * size)).append(" ");
                }
            }
        }
        writeToFile(stringBuilder.deleteCharAt(stringBuilder.length() - 1), fileSequence);
    }

    private void generateDiagonalUp(int size, int unbrokenLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X ");
        for (int i = unbrokenLine - 1; i <= ((size - unbrokenLine) + 1 ) * size; i++) {
            int column = i % size;
            if (column < unbrokenLine - 1) {
                continue;
            }
            for (int j = 0; j < unbrokenLine; j++) {
                int k = i + (j * (size - 1));
                stringBuilder.append(k + 1).append(" ");
                if ((k % size) == size - 1) {
                    stringBuilder.append(k).append(" ");
                } else {
                    stringBuilder.append(k + 1 + 1).append(" ");
                }
            }
        }
        writeToFile(stringBuilder.deleteCharAt(stringBuilder.length() - 1), fileSequence);
    }

    public static void main(String[] args) {
        FileUI fileUI = new FileUI();
        //fileUI.generateHorizontalSequence(4, 3);
        // fileUI.generateVerticalSequence(4, 3);
        fileUI.generateDiagonalUp(4, 3);
    }
}
