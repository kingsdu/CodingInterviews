package DoExercise.HSP_ZCY.A024_二分;

import DoExercise.HSP_ZCY.A023_对数器.DuiShuQi;

import java.util.Arrays;

/**
 * @Author: Du
 * @Date: 2021/6/11 11:54
 * 
 * 
 * 查找数组中，>=value的最左位置
 */
public class C01_BSNearLeft
{
    public static void main(String[] args)
    {
        int maxLen = 10;
        int maxValue = 100;
        int testTimes = 10000;
        
        boolean succeed = true;
    
        for (int i = 0; i < testTimes; i++)
        {
            int[] arr = DuiShuQi.lenRandomValueRandom(maxLen, maxValue);
            Arrays.sort(arr);
            int value = (int)((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
            
            if(bianLi(arr,value) != mostLeftIndex(arr,value)){
                System.out.println(value);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!":"No!");
        
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
            int mid = (L + R) >> 1;
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
