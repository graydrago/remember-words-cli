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

    /**
     * TODO Подумать, учитывать ли статус
     * TODO Переопределить hashCode
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return value == ((Letter) obj).value;
    }
}
