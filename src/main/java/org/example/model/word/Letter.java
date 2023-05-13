package org.example.model.word;

public class Letter {
    public static final boolean HIDE = false;
    public static final boolean SHOW = true;

    protected char symbol;
    protected boolean visible;

    public Letter(char symbol, boolean visible) {
        this.symbol = symbol;
        this.visible = visible;
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

    protected void show() {
        visible = SHOW;
    }
}
