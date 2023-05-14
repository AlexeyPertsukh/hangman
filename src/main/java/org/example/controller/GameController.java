package org.example.controller;

import org.example.controller.factory.PictureFactory;
import org.example.model.Game;
import org.example.model.repository.Repository;
import org.example.model.word.Word;
import org.example.view.dialog.CharLetterDialogView;
import org.example.view.printer.Printer;
import org.example.view.reader.Reader;

import java.util.List;

public class GameController {
    private final static int OPEN_LETTERS = 3;
    private final Printer printer;
    private final Reader reader;
    private final Game game;

    public GameController(Printer printer, Reader reader, Repository repository) {
        this.printer = printer;
        this.reader = reader;

        Word word = new Word(repository.getRandom());
        game = new Game(word);
    }

    public void go() {
        game.openRandomLetters(OPEN_LETTERS);
        CharLetterDialogView dialog = new CharLetterDialogView(printer, reader, "введите букву: ", "недопустимый ввод");

        while (true) {
            String[] picture = PictureFactory.create(game.getFailCount());
            printer.output(picture);
            String stringWord = wordToString(game.getWord());
            printer.output(stringWord);
            printEnteredSymbols();

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

    private static String wordToString(Word word) {
        StringBuilder builder = new StringBuilder();
        word.forEach(letter -> {
            if (letter.isVisible()) {
                builder.append(letter.getValue());
            } else {
                builder.append('_');
            }
        });
        return builder.toString();
    }

    private void printEnteredSymbols() {
        List<Character> symbols = game.getSymbols();
        if (symbols.isEmpty()) {
            printer.output("");
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
        game.getWord().openAllLetters();
        printer.output("[" + wordToString(game.getWord()) + "]");
    }

}
