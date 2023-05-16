package org.example.model.word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Word implements Iterable<Letter> {
    private final Letter[] letters;

    public Word(String s) {
        letters = new Letter[s.length()];
        int index = 0;
        for (char symbol : s.toUpperCase().toCharArray()) {
            letters[index++] = new Letter(symbol);
        }

    }

    public int size() {
        return letters.length;
    }

    public boolean contains(char value) {
        value = Character.toUpperCase(value);

        for (Letter letter : letters) {
            if (letter.getValue() == value) {
                return true;
            }
        }

        return false;
    }

    public void openLetter(char value) {
        if (!contains(value)) {
            throw new IllegalArgumentException("character missing: " + value);
        }

        value = Character.toUpperCase(value);

        for (Letter letter : letters) {
            if (letter.getValue() == value) {
                letter.open();
            }
        }
    }

    public void openLetter(int index) {
        letters[index].open();
    }

    public void openAllLetters() {
        for (Letter letter : letters) {
            letter.open();
        }
    }

    public boolean isAllLettersOpen() {
        for (Letter letter : letters) {
            if (!letter.isVisible()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Letter> iterator() {
        return new LetterIterator();
    }

    public class LetterIterator implements Iterator<Letter> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < letters.length;
        }

        @Override
        public Letter next() {
            return letters[index++];
        }
    }

}
