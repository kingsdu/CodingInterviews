package JavaSE.Book.Success;

import java.util.Comparator;

/**
 * 高级泛型限定的使用
 */
public class SuperComparator implements Comparator<Animial> {

    public int compare(Animial o1, Animial o2) {
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
