package org.example.view.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void output(String message) {
        System.out.println(message);
    }

    @Override
    public void output(String[] messages) {
        for (String s : messages) {
            output(s);
        }
    }
}
