package org.example.model;

import org.example.model.word.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public final static int MAX_FAIL = 6;

    private final Word word;
    private final List<Character> symbols = new ArrayList<>();

    private int failCount;

    public Game(Word word) {
        this.word = word;
    }

    public void addSymbol(char symbol) {
        symbol = Character.toUpperCase(symbol);

        if(symbols.contains(symbol)) {
            return;
        }

        symbols.add(symbol);

        if(word.contains(symbol)) {
            word.openLetter(symbol);
        } else {
            failCount++;
        }
    }

    public Word getWord() {
        return word;
    }

    public List<Character> getSymbols() {
        return symbols;
    }

    public int getFailCount() {
        return failCount;
    }

    public boolean isWin() {
        return word.isAllLettersOpen();
    }

    public boolean isLoose() {
        return failCount >= MAX_FAIL;
    }

    public void openRandomLetters(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < number; i++) {
            word.openLetter(i);
        }

    }

}
