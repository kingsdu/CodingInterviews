package DoExercise.HSP_ZCY.A024_二分;

import java.util.Arrays;

/**
 * @Author: Du
 * @Date: 2021/6/11 11:54
 * 
 * 
 * 查找数组中，>=value 的最左位置
 */
public class C01_BSNearLeft
{
    public static void main(String[] args)
    {
        
        int[] arr = new int[]{7,3,6,0,8,2};
        Arrays.sort(arr);
        System.out.println(mostLeftIndex(arr, 6));

//        int maxLen = 10;
//        int maxValue = 100;
//        int testTimes = 10000;
//
//        boolean succeed = true;
//
//        for (int i = 0; i < testTimes; i++)
//        {
//            int[] arr = DuiShuQi.lenRandomValueRandom(maxLen, maxValue);
//            Arrays.sort(arr);
//            int value = (int)((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
//            int i1 = mostLeftIndex(arr, value);
//            if(bianLi(arr,value) != mostLeftIndex(arr,value)){
//                System.out.println(value);
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!":"No!");
        
    }
    
    public static int mostLeftIndex(int[] arr, int num)
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R)
        {
            int mid = L + ((R - L) >> 1);
            //当大于和等于时，数字依旧会向左移动，所以就会得到value左边第1个位置的数字
            if (arr[mid] >= num)
            {
                ans = mid;
                R = mid - 1;
            } else
            {
                L = mid + 1;
            }
        }
        return ans;
    }
    
    public static int bianLi(int[] arr, int num){
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] >= num){
                return i;
            }
        }
        return -1;
    }
}
