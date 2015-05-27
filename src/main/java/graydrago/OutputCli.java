package graydrago;

import static java.lang.String.format;

/**
 * Вывод символов или массивов символов на консоль с поддержкой escape последовательностей.
 **/
public class OutputCli {
    public static interface Colors {
        final int BLACK = 30;
        final int RED = 31;
        final int GREEN = 32;
        final int YELLOW = 33;
        final int BLUE = 34;
        final int MAGENTA = 35;
        final int CYAN = 36;
        final int WHITE = 37;
    }

    public static void printLetter(Letter l) {
        if (l.getStatus() == Letter.Status.RIGHT) {
            System.out.printf("\033[%d;1m", Colors.GREEN);
        } else {
            System.out.printf("\033[%d;1m", Colors.RED);
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
        System.out.printf("[%s]", w.getTranscription());
    }

    public static void printTranslation(Word w) {
        System.out.printf("\033[3;1m%s", w.getTranslation());
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
