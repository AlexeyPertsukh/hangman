package org.example.view.dialog;

import org.example.model.repository.Repository;
import org.example.view.printer.Printer;
import org.example.view.reader.Reader;

public class CharDialogView {
    private final Printer printer;
    private final Reader reader;
    private final String tittle;
    private final String fail;

    public CharDialogView(Printer printer, Reader reader, String tittle, String fail) {
        this.printer = printer;
        this.reader = reader;
        this.tittle = tittle;
        this.fail = fail;
    }

    public char input() {
        printer.output(tittle);
        while (true) {
            String key = reader.input();
            if(key.length() != 1) {
                printer.output(fail);
            } else {
                return key.charAt(0);
            }
        }
    }
}
