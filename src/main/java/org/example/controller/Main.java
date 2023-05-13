package org.example.controller;

import org.example.model.file_reader.BasicFileReader;
import org.example.model.file_reader.MyFileReader;
import org.example.model.repository.FileRepository;
import org.example.model.repository.Repository;
import org.example.model.word.Word;
import org.example.view.printer.ConsolePrinter;
import org.example.view.printer.Printer;
import org.example.view.reader.KeyboardReader;
import org.example.view.reader.Reader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();

        Repository repository = createRepository();

        GameController controller = new GameController(printer, reader, repository);
        controller.go();
    }

    private static Repository createRepository() {
        String path = new File("").getAbsolutePath();
        String filename = path + "\\src\\main\\resources\\words.txt";

        MyFileReader fileReader = new BasicFileReader(filename);
        return new FileRepository(fileReader, 5);
    }
}