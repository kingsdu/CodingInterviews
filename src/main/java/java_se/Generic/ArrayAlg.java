package java_se.Generic;

public class ArrayAlg {

    public static Pair<String> minmax(String[] a)
    {
        if (a == null || a.length == 0)return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.compareTo(a[i]) > 0) min = a[i];
            System.out.println(min.compareTo(a[i]));
            if (max.compareTo(a[i]) < 0) max = a[i];
            System.out.println(max.compareTo(a[i]));
        }
        return new Pair<String>(min, max);
    }


    public static <T> T getMidedle(T... a){
        return a[a.length/2];
    }
}
