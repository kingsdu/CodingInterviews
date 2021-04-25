package JavaSE.Interview.SortPackages;


/**
 * 快速排序
 */
public class QuickSort
{
    
    public static void main(String[] args)
    {
        int[] array = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort q = new QuickSort();
        q.quickSort(array);
        for (int i : array)
        {
            System.out.print(i + " ");
        }
    }
    
    /**
     * 加这一层是为了程序控制
     *
     * @param array
     */
    public void quickSort(int[] array)
    {
        int len;
        if (array == null
                || (len = array.length) == 0
                || len == 1)
        {
            return;
        }
        recQuickSort(array, 0, len - 1);
    }
    
    public void recQuickSort(int[] arr, int left, int right)
    {
        if (left > right)
        {
            return;
        }
        
        int base = arr[left];
        int i = left, j = right;
        while (i != j)
        {
            //从右边开始是因为pivot在左边
            while (arr[j] >= base && i < j)
            {
                j--;
            }
            while (arr[i] <= base && i < j)
            {
                i++;
            }
            //交换位置
            if (i < j)
            {
                swap(arr, i, j);
            }
        }
        //遍历完成，交换哨兵
        swap(arr, left, j);
        
        recQuickSort(arr, left, j - 1);
        recQuickSort(arr, j + 1, right);
    }
    
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
