package org.example.model.word;

public class Letter {
    public static final boolean DISABLE = false;
    public static final boolean ENABLE = true;

    protected char symbol;
    protected boolean visible;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        if (!visible) {
            throw new IllegalArgumentException("symbol not shown");
        }
        return symbol;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void open() {
        visible = ENABLE;
    }
}
