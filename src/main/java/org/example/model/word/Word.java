package org.example.model.word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Word implements Iterable<Letter> {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String s) {
        for (char symbol : s.toUpperCase().toCharArray()) {
            letters.add(new Letter(symbol));
        }

    }

    public int size() {
        return letters.size();
    }

    public boolean contains(char symbol) {
        symbol = Character.toUpperCase(symbol);

        for (Letter letter : letters) {
            if (letter.getValue() == symbol) {
                return true;
            }
        }

        return false;
    }

    public void openLetter(char symbol) {
        if (!contains(symbol)) {
            throw new IllegalArgumentException("character missing: " + symbol);
        }

        symbol = Character.toUpperCase(symbol);

        for (Letter letter : letters) {
            if (letter.getValue() == symbol) {
                letter.open();
            }
        }
    }

    public void openLetter(int index) {
        letters.get(index).open();
    }

    public void openAllLetters() {
        letters.forEach(Letter::open);
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
            return index < letters.size();
        }

        @Override
        public Letter next() {
            return letters.get(index++);
        }
    }

}
