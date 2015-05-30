package graydrago;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Основной класс запускающий весь процесс.
 */
public class Application {
    private final static String COMMAND_HINT = "?";
    private final static String COMMAND_LONG_HINT = "\\hint";
    
    private final static String COMMAND_EXIT = "\\e";
    private final static String COMMAND_LONG_EXIT = "\\exit";
    
    private final static String COMMAND_HELP = "\\h";
    private final static String COMMAND_LONG_HELP = "\\help";
    
    private WordList list;
    private final ResourceBundle bundle;
    
    private Scanner scanner = null;

    /**
     * Конструктор
     * 
     * @param list Список слов.
     * @param bundle Ресурсы с локализацией текста.
     */
    public Application(WordList list, ResourceBundle bundle) {
        this.list = list;
        this.bundle = bundle;
    }

    public String getUserInput() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }
    
    public void printHelp() {
        OutputCli.println(bundle.getString("help_text"));
        OutputCli.printf("%s - %s\n", COMMAND_HINT, bundle.getString("help_hint"));
        OutputCli.printf("%s - %s\n", COMMAND_EXIT, bundle.getString("help_exit"));
        OutputCli.printf("%s - %s\n", COMMAND_HELP, bundle.getString("help_help"));
    }

    public void run() {
        boolean do_main_loop = true;
        String input;
        
        list.shuffle();
        for (Word word : list) {
            
            OutputCli.printf("%s: %d\n", bundle.getString("the_number_of_words"), list.size());
            
            while (true) {
                OutputCli.println(word.getTranslation());
                input = getUserInput();

                if (input.equals(COMMAND_HINT) || input.equals(COMMAND_LONG_HINT)) {
                    list.add(word);
                    OutputCli.printf("%s: %s\n", bundle.getString("hint"), word.getWord());
                    continue;
                }
                
                if (input.equals(COMMAND_HELP) || input.equals(COMMAND_LONG_HELP)) {
                    printHelp();
                    continue;
                }

                if (input.equals(COMMAND_EXIT) || input.equals(COMMAND_LONG_EXIT)) {
                    do_main_loop = false;
                    break;
                }

                OutputCli.printLetters(word.getDifferences(input));
                OutputCli.printf(" [%s]\n", word.getTranscription());
                if (word.compare(input)) {
                    break;
                } else {
                    list.add(word);
                }
            }
            list.shuffle();
            if (!do_main_loop) break;
        }
            
        if (list.size() == 0) {
            OutputCli.println(bundle.getString("congratulation"));
        } else {
            OutputCli.println(bundle.getString("bye"));
        }
    }
}
