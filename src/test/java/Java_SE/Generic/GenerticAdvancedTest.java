package Java_SE.Generic;

import org.junit.Test;

import java.util.ArrayList;

public class GenerticAdvancedTest {

    @Test
    public void generticPrintCol(){
        ArrayList<String> a1 = new ArrayList<String>();

        a1.add("abc1");
        a1.add("abc2");
        a1.add("abc3");

        ArrayList<Integer> a2 = new ArrayList<Integer>();

        a2.add(3);
        a2.add(2);
        a2.add(6);

        GenerticAdvanced.printColl(a1);
        GenerticAdvanced.printColl(a2);
    }


    @Test
    public void generticPrintCol_1(){
        ArrayList<Animial> dogs = new ArrayList<Animial>();

        dogs.add(new Animial("wangcai1"));
        dogs.add(new Animial("wangcai2"));
        dogs.add(new Animial("wangcai3"));

        GenerticAdvanced.printColl_1(dogs);
    }

    @Test
    public void superComparatorTest(){
        GenerticAdvanced.superComparator();
    }




}