package graydrago;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Загрузка слов из файла в список.
 */
public class WordLoader {
    /**
     * Экземпляров этого класса создавать не нужно.
     */
    private WordLoader() {}
    
    private static final Logger log = Logger.getLogger(WordLoader.class.getName());

    /**
     * Загружает список слов из файла.
     * 
     * @param filename Имя файла со списком слов.
     * @return Возвращает список слов.
     */
    public static WordList fromFile(String filename) {
        WordList list = new WordList();

        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                Word word = new Word(parts[0], parts[1], parts[2], "");
                list.add(word);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            log.log(Level.SEVERE, "Import error on line: {0}", line);
            System.exit(1);
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "File not found: {0}", filename);
            System.exit(1);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error reading from file: {0}", filename);
            System.exit(1);
        }
        
        return list;
    }
}
