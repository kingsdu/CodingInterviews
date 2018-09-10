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
        int[] a = {7,6,9,8,4,3};
        SortMethods.insertSort(a);
        for(int i:a){
            System.out.println(i);
        }
    }

    @Test
    public void shellSortSmallToBig() {
        int[] data = new int[] { 32,43,23,13,11};
        int[] result = SortMethods.shellSortSmallToBig(data);
        for(int i : result)
        System.out.println(i);
    }


    @Test
    public void quickSort(){
        int[] arr = {7,6,9,8,4,3};
        SortMethods.quickSort(arr,0,arr.length-1);
        for (int i :
                arr) {
            System.out.print(i);
        }
    }

    @Test
    public void mergeSort_sort(){
        int[] arr = {7,6,9,8,4,3};
        SortMethods.mergeSort_sort(arr,0,arr.length-1,new int[arr.length]);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}