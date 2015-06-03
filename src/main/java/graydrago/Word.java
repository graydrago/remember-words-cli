package graydrago;

/**
 * Слово или выражение.
 */
public class Word {
    private final String word;
    private final String transcription;
    private final String translation;
    private final String context;

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

    public Word(String word, String transcription, String translation, String context) {
        this.word = word;
        this.transcription = transcription;
        this.translation = translation;
        this.context = context;
    }

    public boolean compare(String s) {
        return s.equals(word);
    }

    /**
     * Возвращает различия между словами.
     * 
     * @param s Строка с которой происходит сравнение.
     * @return 
     */
    public Letter[] getDifferences(String s) {
        int s_length = s.length();
        int word_length = word.length();
        int min_length = s_length < word_length ? s_length : word_length;
        int max_length = s_length > word_length ? s_length : word_length;
                
        Letter[] letters = new Letter[max_length];
        
        int i = 0;
        char cs;
        char cword;
        for (; i < min_length; i++) {
            Letter l;
            cs = s.charAt(i);
            if (cs == word.charAt(i)) {
                l = new Letter(cs, Letter.Status.RIGHT);
            } else {
                if (cs == ' ') {
                    l = new Letter('_', Letter.Status.WRONG);
                } else {
                    l = new Letter(cs, Letter.Status.WRONG);
                }
            }

            letters[i] = l;
        }
        
        if (word_length < s_length) {
            for (; i < max_length; i++) {
                letters[i] = new Letter(s.charAt(i), Letter.Status.WRONG);
            }
        } else if (word_length > s_length) {
            for (; i < max_length; i++) {
                letters[i] = new Letter('*', Letter.Status.WRONG);
            }
        }
        
        return letters;
    }
}
