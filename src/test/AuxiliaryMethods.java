package test;

import pr1.Book;

import java.util.List;
import java.util.Random;

public class AuxiliaryMethods {

    public static void shuffle (Object t[]) {
        Random r = new Random();
        Object pivot;
        int a, b;
        for (int i=0; i<=t.length/2; i++) {
            a = r.nextInt(t.length);
            b = r.nextInt(t.length);
            if (a!=b) {
                pivot = t[a];
                t[a] = t[b];
                t[b] = pivot;
            }
        }
    }

    public static boolean doubleInclusion (List<Book> a, List<Book> b) {
        for (Book o : a)
            if (!b.contains(o)) {
                return false;
            }
        for (Book o : b)
            if (!a.contains(o)) {
                return false;
            }
        return true;
    }

    public static boolean sortedOk (List<Book> a, List<Book> b) {
        Book x,y;
        for (int i=0; i<a.size(); i++) {
            x = a.get(i);
            y = b.get(i);
            if (x.getYear()!=y.getYear())
                return false;
        }
        return true;
    }

}
