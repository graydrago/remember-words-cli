package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import graydrago.Letter;

public class LetterTest {
    @Test
    public void equals() {
        assertEquals(new Letter('a'), new Letter('a'));
        assertNotEquals(new Letter('a'), new Letter('b'));
    }
    
    @Test
    public void gettersAndSetters() {
        char a = 'a';
        Letter letter = new Letter(a, Letter.Status.RIGHT);
        assertEquals(letter.getLetter(), a);
        assertEquals(letter.getStatus(), Letter.Status.RIGHT);
        
        char b = 'b';
        letter.setLetter(b);
        letter.setStatus(Letter.Status.WRONG);
        assertEquals(letter.getLetter(), b);
        assertEquals(letter.getStatus(), Letter.Status.WRONG);
    }
}
