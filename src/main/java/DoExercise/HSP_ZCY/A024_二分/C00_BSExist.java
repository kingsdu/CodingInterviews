package DoExercise.HSP_ZCY.A024_二分;

/**
 * @Author: Du
 * @Date: 2021/6/19 10:47
 */
public class C00_BSExist
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(isExist(arr, 3));
    }
    
    //一般的二分算法
    public static boolean isExist(int[] sortedArr, int num)
    {
        if (sortedArr == null || sortedArr.length == 0)
        {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R)
        {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num)
            {
                return true;
            } else if (sortedArr[mid] > num)
            {
                R = mid - 1;
            } else
            {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
    
}
