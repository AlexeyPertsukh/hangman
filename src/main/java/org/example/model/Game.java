package org.example.model;

import org.example.model.word.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public final static int MAX_FAIL = 6;
    private final static int OPEN_LETTERS = 3;
    private final Word word;
    private final List<Character> symbols = new ArrayList<>();

    private int fail;

    public Game(Word word) {
        this.word = word;
        showRandomLetters(OPEN_LETTERS);
    }

    public void addSymbol(char symbol) {
        if (isLoose()) {
            throw new IllegalArgumentException("too many tries ");
        }

        symbol = Character.toUpperCase(symbol);

        if(symbols.contains(symbol)) {
            return;
        }

        symbols.add(symbol);
        if(word.contains(symbol)) {
            word.open(symbol);
        } else {
            fail++;
        }
    }

    public Word getWord() {
        return word;
    }

    public List<Character> getSymbols() {
        return symbols;
    }

    public int getFail() {
        return fail;
    }

    public boolean isWin() {
        return word.allLettersShown();
    }

    public boolean isLoose() {
        return fail >= MAX_FAIL;
    }

    private void showRandomLetters(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < count; i++) {
            word.open(i);
        }

    }

}
