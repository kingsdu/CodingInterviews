package JavaSE.Book.Success;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class GenerticAdvanced {

    public static <T> void printColl(ArrayList<T> al){
        Iterator<T> iterator = al.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static void printColl_1(ArrayList<? extends Animial> al){
        Iterator<? extends Animial> iterator = al.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getCategory());
        }
    }


    /**
     * <? super **>的使用
     */
    public static void superComparator(){
        TreeSet set1 = new TreeSet(new SuperComparator());

        set1.add(new Animial("wangcai1"));
        set1.add(new Animial("wangcai2"));
        set1.add(new Animial("wangcai3"));

        Iterator<Animial> iterator1 = set1.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next().getCategory());
        }

        TreeSet set2 = new TreeSet(new SuperComparator());

        set2.add(new Dog("wangcaiq1"));
        set2.add(new Dog("wangcaiq2"));
        set2.add(new Dog("wangcaiq3"));

        Iterator<Animial> iterator2 = set2.iterator();

        while (iterator2.hasNext()){
            System.out.println(iterator2.next().getCategory());
        }

    }
}
