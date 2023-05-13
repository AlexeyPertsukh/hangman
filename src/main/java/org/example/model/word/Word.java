package org.example.model.word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Word implements Iterable<Letter> {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String s) {
        char[] chars = s.toUpperCase().toCharArray();
        for (char symbol : chars) {
            letters.add(new Letter(symbol, Letter.HIDE));
        }

        List<Letter> temp = new ArrayList<>(letters);
        Collections.shuffle(temp);
        for (int i = 0; i < 3; i++) {
            temp.get(i).show();
        }

    }

    public boolean contains(char symbol) {
        symbol = Character.toUpperCase(symbol);

        for (Letter letter : letters) {
            if (letter.symbol == symbol) {
                return true;
            }
        }

        return false;
    }

    public void open(char symbol) {
        if (!contains(symbol)) {
            throw new IllegalArgumentException("character missing: " + symbol);
        }

        symbol = Character.toUpperCase(symbol);

        for (Letter letter : letters) {
            if (letter.symbol == symbol) {
                letter.show();
            }
        }
    }

    public void openAll() {
        letters.forEach(Letter::show);
    }

    public boolean allLettersShown() {
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
