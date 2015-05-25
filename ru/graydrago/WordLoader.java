package ru.graydrago;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Загрузка слов из файла в список.
 */
public class WordLoader {
    private WordLoader() {}

    public static WordList fromFile(String filename) throws IOException {
        WordList list = new WordList();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] parts = line.split("\\|");

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                Word word = new Word(parts[0], parts[1], parts[2], "");
                list.add(word);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка при импорте строки: " + line);
                System.exit(1);
            }

        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        WordList list = WordLoader.fromFile("/home/gray/tmp/words");
        for (Word word : list) {
            System.out.println(word.getWord());
        }
    }
}
