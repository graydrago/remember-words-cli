package graydrago;

/**
 * Буква с метаданными.
 *
 * Буква имеет состояние отражающее верно она была набрана или нет.
 * Логика отвечающая за изменение состояния должна распологаться в вызывающем коде.
 */
public class Letter {
    public static enum Status { RIGHT, WRONG }
    
    char value;
    Status status;

    public Letter(char value) {
        this(value, Status.RIGHT);
    }

    public Letter(char value, Status status) {
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

    public Status getStatus() {
        return status;
    }

    public Letter setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return String.format("<%c|%s>", value, status == Status.RIGHT ? "R" : "W");
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        
        Letter obj = (Letter) otherObject;
        if (obj.getClass() != Letter.class) return false;
        
        return value == obj.value &&
               status.equals(obj.status);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.value;
        return hash;
    }
}
