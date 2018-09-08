package SortPackages;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortMethodsTest {

    @Test
    public void bubbleSort() {
    }

    @Test
    public void selectSort() {
    }

    @Test
    public void insertSort() {
    }

    @Test
    public void shellSortSmallToBig() {
        int[] data = new int[] { 32,43,23,13,11};
        int[] result = SortMethods.shellSortSmallToBig(data);
        for(int i : result)
        System.out.println(i);
    }

    @Test
    public void faseSortTest(){
        int[] a = {7,6,9,8,4,3};
        int start = 0;
        int end = a.length-1;
        SortMethods.fastSort(a,start,end);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}