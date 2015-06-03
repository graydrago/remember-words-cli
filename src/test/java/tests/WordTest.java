package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import graydrago.Word;
import graydrago.Letter;

public class WordTest {
    @Test
    public void differences() {
        // hello == hello
        Word origin = new Word("hello", "", "", "");
        String testWord = "hello";
        Letter[] equals = {
            new Letter('h'), new Letter('e'), new Letter('l'),
            new Letter('l'), new Letter('o') };
        assertArrayEquals(origin.getDifferences(testWord), equals);
        
        // Когда хранимое в объекте слово длинее.
        // hello != hell, equals hell*
        testWord = "hell";
        equals = new Letter[] {
            new Letter('h'), new Letter('e'), new Letter('l'),
            new Letter('l'), new Letter('*', Letter.Status.WRONG) };
        assertArrayEquals(origin.getDifferences(testWord), equals);
        
        // Когда хранимое в объекте слово короче.
        // hello != hello!, equals hello!
        testWord = "hello!";
        equals = new Letter[] {
            new Letter('h'), new Letter('e'), new Letter('l'),
            new Letter('l'), new Letter('o'),
            new Letter('!', Letter.Status.WRONG) };
        assertArrayEquals(origin.getDifferences(testWord), equals);
        
        // Псевдо случайное сравнение.
        // hello != pedlo, equals pedlo
        testWord = "pedlo";
        equals = new Letter[] {
            new Letter('p', Letter.Status.WRONG),
            new Letter('e'),
            new Letter('d', Letter.Status.WRONG),
            new Letter('l'), new Letter('o') };
        assertArrayEquals(origin.getDifferences(testWord), equals);
        
        // Проверка пробела
        testWord = "     "; // 5 пробелов
        equals = new Letter[] {
            new Letter('_', Letter.Status.WRONG),
            new Letter('_', Letter.Status.WRONG),
            new Letter('_', Letter.Status.WRONG),
            new Letter('_', Letter.Status.WRONG),
            new Letter('_', Letter.Status.WRONG) };
        assertArrayEquals(origin.getDifferences(testWord), equals);
    }
}
