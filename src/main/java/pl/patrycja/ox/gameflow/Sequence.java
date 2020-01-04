package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Sequence {

    private String fileSequence = "src/main/resources/pl/patrycja/ox/ui/test_sequence.txt";
    private int size;
    private int unbrokenLine;
    private int towards;

    public Sequence(GameSettings gameSettings, String towards) {
        this.size = gameSettings.getBoardSize();
        this.unbrokenLine = gameSettings.getUnbrokenLine();
        this.towards = Integer.parseInt(towards);
    }

    public void generateSequence() {
        switch (towards) {
            case 0: {
                generateHorizontalSequence(size, unbrokenLine);
                break;
            }
            case 1: {
                generateVerticalSequence(size, unbrokenLine);
                break;
            }
            case 2: {
                generateDiagonalUp(size, unbrokenLine);
                break;
            }
            case 3: {
                generateDiagonalDown(size, unbrokenLine);
                break;
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
                if (j != unbrokenLine - 1) {
                    if (i + j + size < size * size) {
                        stringBuilder.append(i + j + size + 1).append(" ");
                    } else {
                        stringBuilder.append((i + j - size) + 1).append(" ");
                    }
                }
            }
        }
        writeToFile(stringBuilder, fileSequence);
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
                if (j != unbrokenLine - 1) {
                    if (column < size - 1) {
                        stringBuilder.append((i + (j * size)) + 1 + 1).append(" ");
                    } else {
                        stringBuilder.append(i + (j * size)).append(" ");
                    }
                }
            }
        }
        writeToFile(stringBuilder, fileSequence);
    }

    private void generateDiagonalUp(int size, int unbrokenLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X ");
        for (int i = unbrokenLine - 1; i <= ((size - unbrokenLine) + 1) * size; i++) {
            int column = i % size;
            if (column < unbrokenLine - 1) {
                continue;
            }
            for (int j = 0; j < unbrokenLine; j++) {
                int k = i + (j * (size - 1));
                stringBuilder.append(k + 1).append(" ");
                if (j != unbrokenLine - 1) {
                    if ((k % size) == size - 1) {
                        stringBuilder.append(k).append(" ");
                    } else {
                        stringBuilder.append(k + 1 + 1).append(" ");
                    }
                }
            }
        }
        writeToFile(stringBuilder, fileSequence);
    }

    private void generateDiagonalDown(int size, int unbrokenLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X ");
        for (int i = 0; i <= (((size - unbrokenLine) + 1) * size) - unbrokenLine; i++) {
            int column = i % size;
            if (column > size - unbrokenLine) {
                continue;
            }
            for (int j = 0; j < unbrokenLine; j++) {
                int k = i + (j * (size + 1));
                stringBuilder.append(k + 1).append(" ");
                if (j != unbrokenLine - 1) {
                    if ((k % size) == size - 1) {
                        stringBuilder.append(k).append(" ");
                    } else {
                        stringBuilder.append(k + 1 + 1).append(" ");
                    }
                }
            }
        }
        writeToFile(stringBuilder, fileSequence);
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
}
