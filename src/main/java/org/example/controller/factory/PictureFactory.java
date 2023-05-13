package org.example.controller.factory;

public class PictureFactory {

    private static final String[] PIC0 = {
            "  +---+  ",
            "  |   |  ",
            "      |  ",
            "      |  ",
            "      |  ",
            "      |  ",
            "========="};

    private static final String[] PIC1 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            "      |  ",
            "      |  ",
            "      |  ",
            "========="};

    private static final String[] PIC2 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            "  |   |  ",
            "      |  ",
            "      |  ",
            "========="};

    private static final String[] PIC3 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            " /|   |  ",
            "      |  ",
            "      |  ",
            "========="};

    private static final String[] PIC4 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            " /|\\  |  ",
            "      |  ",
            "      |  ",
            "========="};
    private static final String[] PIC5 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            " /|\\  |  ",
            " /    |  ",
            "      |  ",
            "========="};

    private static final String[] PIC6 = {
            "  +---+  ",
            "  |   |  ",
            "  O   |  ",
            " /|\\  |  ",
            " / \\  |  ",
            "      |  ",
            "========="};

    private static final String[][] PICS = {PIC0, PIC1, PIC2, PIC3, PIC4, PIC5, PIC6};

    public static String[] create(int pictureNumber) {
        return PICS[pictureNumber];
    }
}
