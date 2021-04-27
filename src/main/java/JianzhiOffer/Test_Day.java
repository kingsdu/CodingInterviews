package JianzhiOffer;

/**
 * 每日一练，自己写算法
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Test_Day t = new Test_Day();
        t.heapSort(nums);
    }
    
    
    /**
     *
     */
    public void heapSort(int[] arr)
    {
        if (arr == null || arr.length == 0) return;
        
        int n = arr.length;
        buildHeap(arr, n);
        
        for (int i = n - 1; i >= 0; i--)
        {
            swap(arr, i, 0);
            heapify(arr, i, 0);//剪枝后需要从最后一位开始
        }
        
    }
    
    
    /**
     * 第一次，对所有的数据进行排序
     *
     * @param arr
     * @param n
     */
    public void buildHeap(int[] arr, int n)
    {
        int last = n - 1;
        int lastParent = (last - 1) >> 1;
        for (int i = lastParent; i >= 0; i--)
        {
            heapify(arr, n, i);//从底到头的堆化
        }
    }
    
    
    public void heapify(int[] arr, int n, int i)
    {
        if (n < i)
        {
            return;
        }
        
        int child1 = i * 2 + 1;
        int child2 = i * 2 + 2;
        int max = i;
        
        if (arr[max] < arr[child1] && child1 < n)
        {
            max = child1;
        }
        
        if (arr[max] < arr[child2] && child2 < n)
        {
            max = child2;
        }
        
        if (max != i)
        {
            swap(arr, max, i);
            heapify(arr, n, max);
        }
    }
    
    
    public void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    
}
