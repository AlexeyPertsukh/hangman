package org.example.model.word;

public class Letter {
    private final char value;
    private boolean visible;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void open() {
        visible = true;
    }
}
