package graydrago;

import java.io.IOException;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Main {
    private static ResourceBundle bundle = null;
    
    public static void printHelp(String[] args) {
        System.out.printf("%s:\n$ ./run.sh file_name.txt\n", bundle.getString("usage"));
    }

    public static void main(String[] args) throws IOException {
        try {
            // Warning! Может возникнуть проблема с UTF-8, но пока её не наблюдаю.
            bundle = ResourceBundle.getBundle("l10n.Package");
        } catch(MissingResourceException e) {
            System.out.println("Language package not found.");
        }
        
        if (args.length == 0) {
            printHelp(args);
            return;
        }

        WordList list = WordLoader.fromFile(args[0]);
        Game game = new Game(list, bundle);
        game.run();
    }
}
