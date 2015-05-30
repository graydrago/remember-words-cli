package graydrago;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Инициализация приложения
 */
public class Main {
    private static ResourceBundle bundle = null;
    private static final Logger log = Logger.getLogger(Main.class.getName());
    
    public static void printHelp(String[] args) {
        System.out.printf("%s:\n$ ./run.sh file_name.txt\n", bundle.getString("usage"));
    }

    public static void main(String[] args) throws IOException {
        InputStream logConf = Main.class.getResourceAsStream("logging.properties");
        if (logConf != null) {
            LogManager.getLogManager().readConfiguration(logConf);
        }

        try {
            bundle = ResourceBundle.getBundle("l10n.Package");
        } catch(MissingResourceException e) {
            log.severe("Language package not found.");
            System.exit(1);
        }
        
        if (args.length == 0) {
            printHelp(args);
            return;
        }

        WordList list = WordLoader.fromFile(args[0]);
        Application game = new Application(list, bundle);
        game.run();
    }
}
