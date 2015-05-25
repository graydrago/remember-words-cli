package graydrago;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void printHelp(String[] args) {
        System.out.println("Usage: ./run.sh file_name.txt");
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            printHelp(args);
            return;
        }

        WordList list = WordLoader.fromFile(args[0]);
        Game game = new Game(list);
        game.run();
    }
}
