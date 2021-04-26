package JianzhiOffer;


import DataStruct.HSP.Day01.Array;

import java.util.Arrays;

/**
 * 每日一练，自己写算法
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        Test_Day t = new Test_Day();
        int[] ints = t.recQuickSort(nums, 0, nums.length - 1, k - 1);
        for (int x :
                ints)
        {
            System.out.print(x + " ");
        }
    }
    
    public int[] recQuickSort(int[] arr, int left, int right,int k)
    {
        if(arr.length == 0 || k == 0){
            return new int[0];
        }
        
        int j = partitionIt(arr,left,right);
        if(j == k){
            return Arrays.copyOf(arr,j+1);
        }
        return j > k ? recQuickSort(arr,left,j-1,k) : recQuickSort(arr,j+1,right,k);
    }
    
    public int partitionIt(int[] arr, int left, int right)
    {
        int i = left,j = right+1;
        int base = arr[left];
        
        while (i != j){
            while (++i <= right && base < arr[i]);
            while (--j >= left && base > arr[j]);
            
            if(i>=j){
                break;
            }
            
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        
        arr[left] = arr[j];
        arr[j] = base;
        
        return j;
    }
    

    
    
}
