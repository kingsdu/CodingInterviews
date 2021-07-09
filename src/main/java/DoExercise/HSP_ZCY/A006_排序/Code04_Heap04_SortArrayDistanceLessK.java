package DoExercise.HSP_ZCY.A006_排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Du
 * @Date: 2021/7/9 11:42
 */
public class Code04_Heap04_SortArrayDistanceLessK
{
    public static void sortedArrDistanceLessK(int[] arr, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>();// 默认小根堆
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++)
        {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++)
        {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty())
        {
            arr[i++] = heap.poll();
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = {3,6,4,1,2,11,9,12,7};
        int k = 5;
        sortedArrDistanceLessK(arr,k);
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
    }
}
