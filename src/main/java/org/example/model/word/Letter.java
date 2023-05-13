package org.example.model.word;

public class Letter {
    protected char symbol;
    protected boolean visible;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        if (!visible) {
            throw new IllegalArgumentException("symbol getting fail: letter not open");
        }
        return symbol;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void open() {
        visible = true;
    }
}
