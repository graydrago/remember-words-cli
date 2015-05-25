package ru.graydrago;

import java.io.File;
import java.util.Iterator;

/**
 * I learn Java.
 */
class Itr implements Iterable<Integer> {
    Integer i = 0;
    final int max;

    Itr(int max) {
        this.max = max;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return i < max;
            }

            @Override
            public Integer next() {
                return ++i;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class Test {
    public static void print_file_name(File name, int deep) {
        while(deep-- > 0) { System.out.print(".."); }
        if (name.isDirectory()) {
            System.out.print("/");
        } else {
            System.out.print("|");
        }
        System.out.println(name.getName());
    }

    public static void dir_tree(File dir, int deep) {
        print_file_name(dir, deep);
        if (dir.isDirectory()) {
            for (String name : dir.list()) {
                dir_tree(new File(dir.getPath() + "/" + name), deep + 1);
            }
        }
    }

    public static void dir_tree(File dir) {
        dir_tree(dir, 0);
    }

    public static void main(String[] args) {
        Itr itr = new Itr(4);
        for (int i : itr) {
            System.out.println(i);
        }

        File file = new File(".");
        dir_tree(file);
    }
}
