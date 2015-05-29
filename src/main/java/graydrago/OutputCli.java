package graydrago;

import static java.lang.String.format;
import static java.lang.System.out;
import sun.org.mozilla.javascript.ScriptRuntime;

/**
 * Вывод на консоль с поддержкой escape последовательностей.
 */
public class OutputCli {
    public static enum Color {
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        MAGENTA(35),
        CYAN(36),
        WHITE(37);
        
        private final int colorIndex;
        Color(int colorIndex) {
            this.colorIndex = colorIndex;
        }
        
        public int get() {
            return colorIndex;
        };
        
        @Override
        public String toString() {
            return String.valueOf(colorIndex);
        }
    }

    /**
     * Перемещает курсор в указанную позицию.
     * 
     * @param x
     * @param y 
     */
    public static void moveCursor(int x, int y) {
        printf("\033[%d;%dH", y, x);
    }

    /**
     * Сбрасывает параметры форматирования.
     */
    public static void reset() {
        print("\033[0m");
    }
    
    /**
     * Печатает символ.
     * 
     * Подсвечивает символ в зависимости от его характеристик.
     * 
     * @param l 
     */
    public static void printLetter(Letter l) {
        if (l.getStatus() == Letter.Status.RIGHT) {
            setColor(Color.GREEN);
        } else {
            setColor(Color.RED);
        }
        print(Character.toString(l.getLetter()));
        reset();
    }

    /**
     * Печатает массив символов.
     * 
     * Подсвечивает символы в зависимости от их характеристик.
     * 
     * @param letters 
     */
    public static void printLetters(Letter[] letters) {
        for (Letter l : letters) {
            printLetter(l);
        }
    }

    /**
     * Очищает экран и устанавливает курсор в левый верхний угол.
     */
    public static void clearScreen() {
       print("\33[2J");
    }
    
    /**
     * Задаёт цвет текста перед выводом.
     * 
     * @param color 
     */
    public static void setColor(Color color) {
        printf("\33[%s;1m", color);
    }
    
    /**
     * Вывод строки c параметрами.
     * 
     * Декорирую вывод в терминал для придания единообразного вида коду.
     * @param string 
     * @param args 
     */
    public static void printf(String string, Object... args) {
        out.printf(string, args);
    }
    
    /**
     * Вывод строки.
     * 
     * Декорирую вывод в терминал для придания единообразного вида коду.
     * @param string 
     */
    public static void print(String string) {
        out.print(string);
    }
    
    /**
     * Вывод строки с переводом строки.
     * 
     * Декорирую вывод в терминал для придания единообразного вида коду.
     * @param string 
     */
    public static void println(String string) {
        out.println(string);
    }

    /**
     * Перед закрытием программы сбрасывает настройки форматирования.
     * 
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        reset();
        super.finalize();
    }
}
