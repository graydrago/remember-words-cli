package graydrago;

/**
 * Буква с метаданными.
 *
 * Буква имеет состояние отражающее верно она была набрана или нет.
 * Логика отвечающая за изменение состояния должна распологаться в вызывающем коде.
 *
 * Created by gray on 26.02.15.
 */
public class Letter {
    public enum type_status { RIGHT, WRONG }
    char value;
    type_status status;

    Letter(char value) {
        this(value, type_status.RIGHT);
    }

    Letter(char value, type_status status) {
        this.value = value;
        this.status = status;
    }

    public char getLetter() {
        return value;
    }

    public Letter setLetter(char letter) {
        this.value = letter;
        return this;
    }

    public type_status getStatus() {
        return status;
    }

    public Letter setStatus(type_status status) {
        this.status = status;
        return this;
    }

    public String toString() {
        return "<" + value + "|" + (status == type_status.RIGHT ? "R" : "W") + ">";
    }

    public static void main(String[] args) {
        Letter a = new Letter('a');
        System.out.println(a);
        System.out.println(a.getLetter());
        System.out.println(a.setLetter('b').getLetter());
        System.out.println(a.setLetter('c').setStatus(type_status.WRONG));
    }
}
