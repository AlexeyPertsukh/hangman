package org.example.controller;

import org.example.model.repository.Repository;
import org.example.model.word.Word;
import org.example.view.printer.ConsolePrinter;
import org.example.view.printer.Printer;
import org.example.view.reader.KeyboardReader;
import org.example.view.reader.Reader;

public class MainFake {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();

        Repository repository = new Repository() {
            @Override
            public String getRandom() {
                return "МАДРИД";
            }
        };

        GameController controller = new GameController(printer, reader, repository);
        controller.go();
    }
}
