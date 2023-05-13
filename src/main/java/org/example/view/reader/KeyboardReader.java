package org.example.view.reader;

import java.util.Scanner;

public class KeyboardReader implements Reader{
    @Override
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
