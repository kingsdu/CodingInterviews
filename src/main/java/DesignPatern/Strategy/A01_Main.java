package DesignPatern.Strategy;

import java.util.Arrays;

/**
 * writing tests first!
 * extreme programming
 */
public class A01_Main
{
    public static void main(String[] args) {
        //int[] a = {9, 2, 3, 5, 7, 1, 4};
        A03_Cat[] a = {new A03_Cat(3, 3), new A03_Cat(5, 5), new A03_Cat(1, 1)};
        //Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        A02_Sorter<A03_Cat> sorter = new A02_Sorter<>();
        sorter.sort(a, (o1, o2)->{
            if(o1.weight < o2.weight) return -1;
            else if (o1.weight>o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));
    }
}
