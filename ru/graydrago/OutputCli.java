package ru.graydrago;

import static java.lang.String.format;

/**
 * Вывод символов или массивов символов на консоль с поддержкой escape последовательностей.
 **/
public class OutputCli {
    public static interface Colors {
        final String BLACK = "30";
        final String RED = "31";
        final String GREEN = "32";
        final String YELLOW = "33";
        final String BLUE = "34";
        final String MAGENTA = "35";
        final String CYAN = "36";
        final String WHITE = "37";
    }

    public static void printLetter(Letter l) {
        if (l.getStatus() == Letter.type_status.RIGHT) {
            System.out.printf("\033[%s;1m", Colors.GREEN);
        } else {
            System.out.printf("\033["+Colors.RED+";1m");
        }
        System.out.print(l.getLetter());
        System.out.print("\033[0m");
    }

    public static void moveCursor(int x, int y) {
        System.out.printf("\033[%d;%dH", y, x);
    }

    public static void reset() {
        System.out.print("\033[0m");
    }

    public static void printLetters(Letter[] letters) {
        for (Letter l : letters) {
            printLetter(l);
        }
    }

    public static void printTranscription(Word w) {
        System.out.print("["+w.getTranscription()+"]");
    }

    public static void printTranslation(Word w) {
        System.out.print("\033[3;1m"+w.getTranslation());
        reset();
    }

    public static void clearScreen() {
        System.out.print("\33[2J");
    }

    protected void finalize() throws Throwable {
        reset();
        super.finalize();
    }

    public static void main(String[] args) {
        Word new_word = new Word("suppose", "sə'pəuz", "предполагать", "");
        Letter[] letters = new_word.differents("supose");
        OutputCli.printLetters(letters);
        OutputCli.printTranscription(new_word);
        OutputCli.printTranslation(new_word);
        System.out.println();
    }
}
