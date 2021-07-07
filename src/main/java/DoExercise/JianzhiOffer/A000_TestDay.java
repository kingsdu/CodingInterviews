package DoExercise.JianzhiOffer;

import java.util.Arrays;

//0620:要刷的三道题:12;20;9
//0621:要刷的三道题:13;11;22
//0622:要刷的三道题:7;13;6
//0624:要刷的三道题:6;57;1
//0628:要刷的三道题:7;8;3
//0703:要刷的三道题:17;10;29
//0704:要刷的三道题:18;1;11
//0705:要刷的三道题:38;31;7
//0706:要刷的三道题:6;27;29
//0707:要刷的三道题:9;40;8
public class A000_TestDay
{
    
    public static void main(String[] args)
    {
        A000_TestDay a = new A000_TestDay();
        int[] arr = {1, 2, 10, 4, 1, 4, 3, 3};
        a.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    }
    
    
    public void quickSort(int[] arr, int l, int r)
    {
        if (l > r) return;
        int i = l, j = r;
        while (i < j)
        {
            while (arr[l] <= arr[j] && i < j) j--;
            while (arr[l] >= arr[i] && i < j) i++;
            if (i < j) Offer000_Common.swap(arr, i, j);
        }
        Offer000_Common.swap(arr, l, j);
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, r);
    }
    
    
}
