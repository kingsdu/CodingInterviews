package JavaSE.BLS.Collection;

import java.util.Comparator;

public class StringLength_Comparator implements Comparator {

    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;

        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));

        //注意次要条件
        //字符长度相等，则直接比较字符的大小
        if(num == 0){
            return s1.compareTo(s2);
        }

        return num;
    }
}
