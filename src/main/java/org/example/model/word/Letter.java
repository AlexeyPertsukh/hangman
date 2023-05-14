package org.example.model.word;

public class Letter {
    protected char value;
    protected boolean visible;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        if (!visible) {
            throw new IllegalArgumentException("symbol getting fail: letter not open");
        }
        return value;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void open() {
        visible = true;
    }
}
