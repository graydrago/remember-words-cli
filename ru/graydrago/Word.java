package ru.graydrago;

/**
 * Слово или выражение.
 *
 * Created by gray on 26.02.15.
 */
public class Word {
    private String word;
    private String transcription;
    private String translation;
    private String context;

    public String getWord() {
        return word;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public String getContext() {
        return context;
    }

    Word(String word, String transcription, String translation, String context) {
        this.word = word;
        this.transcription = transcription;
        this.translation = translation;
        this.context = context;
    }

    public boolean compare(String s) {
        return s.equals(word);
    }

    public Letter[] differents(String s) {

        int length = s.length() > word.length() ? s.length() : word.length();
        char[] original_word = word.toCharArray();
        char[] attempt_word = s.toCharArray();
        Letter[] letters = new Letter[length];

        for ( int i = 0; i < length; i++ ) {
            char o, a;

            // o < a
            try {
                o = original_word[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                letters[i] = new Letter(attempt_word[i], Letter.type_status.WRONG);
                continue;
            }

            // o > a
            try {
                a = attempt_word[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                letters[i] = new Letter('*', Letter.type_status.WRONG);
                continue;
            }

            // o == a
            if (a == o) {
                letters[i] = new Letter(a, Letter.type_status.RIGHT);
            } else {
                letters[i] = new Letter(a, Letter.type_status.WRONG);
            }
        }

        return letters;
    }

    public static void main(String[] args) {
        Word w = new Word("hello", "hello", "привет", "hello, world");
        for ( Letter l : w.differents("heldod")) {
            System.out.println(l);
        }
    }
}
