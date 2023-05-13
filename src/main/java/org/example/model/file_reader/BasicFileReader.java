package org.example.model.file_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicFileReader implements MyFileReader {

    private final String filename;

    public BasicFileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() {
        List<String> words = new ArrayList<>();
        File file = new File(filename);

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("read file error: " + filename);
        }

        while (sc.hasNext()) {
            String word = sc.nextLine();
            words.add(word);
        }
        return words;
    }
}
