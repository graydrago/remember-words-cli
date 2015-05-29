package graydrago;

import java.util.ResourceBundle;
import java.util.Scanner;

import graydrago.OutputCli;

/**
 * Основной класс запускающий весь процесс.
 */
public class Game {
    private final String COMMAND_HINT = "\\?";
    private final String COMMAND_LONG_HINT = "\\hint";
    
    private final String COMMAND_EXIT = "\\e";
    private final String COMMAND_LONG_EXIT = "\\exit";
    
    private WordList list;
    private ResourceBundle bundle;
    
    private Scanner scanner = null;

    /**
     * Конструктор
     * 
     * @param list Список слов.
     * @param bundle Ресурсы с локализацией текста. 
     */
    public Game(WordList list, ResourceBundle bundle) {
        this.list = list;
        this.bundle = bundle;
    }

    public String getUserInput() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
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
                    OutputCli.printf("%s: %s", bundle.getString("hint"), word.getWord());
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
