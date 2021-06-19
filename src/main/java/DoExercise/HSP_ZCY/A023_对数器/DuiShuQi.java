package DoExercise.HSP_ZCY.A023_对数器;

/**
 * @Author: Du
 * @Date: 2021/6/11 10:53
 * <p>
 *
 * 利用对数器验证算法的有效性
 */
public class DuiShuQi
{
    
    public static void main(String[] args)
    {
        useDSQ();
    }
    
    
    public static void useDSQ()
    {
        int maxLen = 10;
        int maxValue = 100;
        int testTimes = 10000;
        System.out.println("start");
        for (int i = 0; i < testTimes; i++)
        {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);//得到随机数组
            int[] tmp = copyArray(arr);//复制数组
            insertSort(arr);
            selectSort(arr);
            if (!isSorted(arr))
            {
                for (int j = 0; j < tmp.length; j++)
                {
                    System.out.print(tmp[j] + ",");
                }
                System.out.println();
                System.out.println("排序有误");
            }
        }
        System.out.println("end!");
    }
    
    
    public static boolean isSorted(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (max > arr[i])//一直递增才是有序的，后面的数一定比前面的数字小
            {
                return false;
            }
            max = Math.min(max, arr[i]);
        }
        return true;
    }
    
    /**
     * 等值的复制数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr)
    {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            ans[i] = arr[i];
        }
        return ans;
    }
    
    
    public static int[] lenRandomValueRandom(int maxLen, int maxValue)
    {
        int len = (int) (Math.random() * maxLen);//数组长度在[0,maxLen]随机分布
        int[] ans = new int[len];
        for (int i = 0; i < len; i++)
        {
            ans[i] = (int) (Math.random() * maxValue);//数组值在[0,maxValue]随机分布
        }
        return ans;
    }
    
    
    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--)
            {
                swap(arr, j, j + 1);
            }
        }
    }
    
    
    public static void selectSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    
    private static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}
