package org.example.controller;

import org.example.controller.factory.PictureFactory;
import org.example.model.Game;
import org.example.model.repository.Repository;
import org.example.model.word.Word;
import org.example.view.dialog.CharDialogView;
import org.example.view.printer.Printer;
import org.example.view.reader.Reader;

import java.util.List;

public class GameController {
    private final Printer printer;
    private final Reader reader;
    //    private final Repository repository;
    private final Game game;

    public GameController(Printer printer, Reader reader, Repository repository) {
        this.printer = printer;
        this.reader = reader;

//        this.repository = repository;
        Word word = new Word(repository.getRandom());
        game = new Game(word);
    }

    public void go() {
        CharDialogView dialog = new CharDialogView(printer, reader, "введите букву: ", "ошибка ввода");
        while (true) {
            String[] picture = PictureFactory.create(game.getFail());
            printer.output(picture);
            printer.output(wordToString(game.getWord()));
            printEnteredSymbols(game.getSymbols());

            if (game.isWin()) {
                printWin();
                break;
            }

            if (game.isLoose()) {
                printLoose();
                break;
            }

            char symbol = dialog.input();
            game.addSymbol(symbol);

        }
    }

    private String wordToString(Word word) {
        StringBuilder builder = new StringBuilder();
        word.forEach(letter -> {
            if (letter.isVisible()) {
                builder.append(letter.getSymbol());
            } else {
                builder.append('_');
            }
        });
        return builder.toString();
    }

    private void printEnteredSymbols(List<Character> symbols) {
        if (symbols.isEmpty()) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < symbols.size(); i++) {
            char symbol = Character.toUpperCase(symbols.get(i));
            builder.append(symbol);
            if (i != symbols.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]\n");
        printer.output(builder.toString());
    }

    private void printWin() {
        printer.output("ВЫ ВЫИГРАЛИ!");
    }

    private void printLoose() {
        printer.output("Вы проиграли...");
        game.getWord().openAll();
        printer.output("[" + wordToString(game.getWord()) + "]");
    }

}
