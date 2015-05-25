package graydrago;

import java.util.Scanner;

/**
 * Created by gray on 24.03.15.
 */
public class Game {
    WordList list;

    public Game(WordList list) {
        this.list = list;
    }

    static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void run() {
        boolean do_loop = true;
        String input;

        for (Word word : list) {
            System.out.println("Осталось: " + list.size());
            System.out.println();

            while (true) {
                System.out.println(word.getTranslation());
                input = getUserInput();

                if (input.equals("?")) {
                    list.add(word);
                    System.out.println("The prompt: " + word.getWord());
                    continue;
                }

                if (input.equals("\\e") || input.equals("\\exit")) {
                    do_loop = false;
                    break;
                }

                OutputCli.printLetters(word.differents(input));
                System.out.print(" [" + word.getTranscription() + "]");
                System.out.println();
                if (word.compare(input)) {
                    break;
                } else {
                    list.add(word);
                }
            }
            if (!do_loop) break;
            list.shuffle();
        }
        System.out.println("You are great!!!\nGame Over.\n");
    }
}
