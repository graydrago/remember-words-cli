package graydrago;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс помогает создать итератор слов.
 */
public class WordList implements Iterable<Word> {
    private LinkedList<Word> queue;

    public WordList() {
        queue = new LinkedList<Word>();
    }

    public void add(Word word) {
        queue.addFirst(word);
    }

    public int size() {
        return queue.size();
    }

    public void shuffle() {
        Collections.shuffle(queue);
    }

    @Override
    public Iterator<Word> iterator() {
        return new Iterator<Word>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Word next() {
                return queue.pollLast();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        WordList list = new WordList();
        Word w1 = new Word("shake (shook, shaken)", "ʃeɪk", "трясти", "");
        Word w2 = new Word("choose (chose, chosen)", "ʧuːz", "выбирать", "");
        Word w3 = new Word("agree (agreed, agreed)", "ə'griː", "соглашаться", "");
        list.add(w1); list.add(w2); list.add(w3);
        list.add(w1); list.add(w2); list.add(w3);
        list.add(w1); list.add(w2); list.add(w3);

        int i = 3;
        for(Word word : list) {
            System.out.println(word.getWord());
            if (--i < 0) {
                list.add(word);
                i = 3;
            }
        }
    }
}