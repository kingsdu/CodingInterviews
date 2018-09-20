package Java_SE.Generic;

import org.junit.Test;

public class ArrayAlgTest {

    @Test
    public void minmax() {
        String[] words = { "1", "2", "3", "4", "5" };
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    @Test
    public void getMiddle(){
//        String middle = ArrayAlg.getMidedle("john","Q.","Public","aaca","qw");
        Integer midedle = ArrayAlg.getMidedle(2, 3, 5, 6, 1);
        System.out.println(midedle);
    }
}