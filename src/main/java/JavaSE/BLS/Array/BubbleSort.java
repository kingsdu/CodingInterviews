package JavaSE.BLS.Array;

public class BubbleSort
{
    
    
    public static void main(String[] args)
    {
        int[] arr = {6, 3, 5, 1, 2, 4, 8};
        BubbleSort bu = new BubbleSort();
        bu.bubbleSort_1(arr);
        for (int x :
                arr)
        {
            System.out.print(x + " ");
        }
    }
    
    
    /**
     *
     * 冒泡排序和选择排序不同
     * 冒泡是一轮确定一个数
     *
     * @param arr
     */
    public void bubbleSort_1(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
