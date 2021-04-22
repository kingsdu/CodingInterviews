package JavaSE.BLS.Array;

public class SelectSort
{
    
    
    public static void main(String[] args)
    {
        int[] arr = {6, 3, 5, 1, 2, 4, 8};
        SelectSort bu = new SelectSort();
        bu.SelectSort_1(arr);
        for (int x :
                arr)
        {
            System.out.print(x+" ");
        }
    }
    
    public void SelectSort_1(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            for (int j = i+1; j <arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
