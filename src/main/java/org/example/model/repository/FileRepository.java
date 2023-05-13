package org.example.model.repository;

import org.example.model.file_reader.MyFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileRepository implements Repository {
    private final List<String> words = new ArrayList<>();

    public FileRepository(MyFileReader fileReader, int minWordLength) {
        List<String> temp = fileReader.read();
        temp.forEach(s -> {
            if(s.length() >= minWordLength) {
                words.add(s);
            }
        });

        Collections.shuffle(words);
    }

    @Override
    public String getRandom() {
        return words.remove(words.size() - 1);
    }

}
