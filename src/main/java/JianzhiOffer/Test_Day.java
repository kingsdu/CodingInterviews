package JianzhiOffer;


/**
 * 每日一练，自己写算法
 */
public class Test_Day
{
    
    
    public void recQuickSort(int[] arr, int left, int right)
    {
        if (left >= right)
        {
            return;
        } else
        {
            int index = partitionIt(arr, left, right);
            recQuickSort(arr, left, index - 1);
            recQuickSort(arr, index + 1, right);
        }
    }
    
    public int partitionIt(int[] arr, int left, int right)
    {
        int i = left, j = right;
        int pivot = arr[left];
        
        while (i != j)
        {
            while (++i < j && arr[i] < pivot) ;
            while (--j > 0 && arr[j] > pivot) ;
            
            if (i >= j)
            {
                break;
            }
            
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        
        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }
    
}
