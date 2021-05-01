package JianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * {67,0,24,58}
 * [58,24,0,67]
 */
public class Test_Day
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6, 7};
        int k = 2;
        Test_Day t = new Test_Day();
        int i = t.binarySerach(arr, 0, arr.length - 1, k);
        System.out.println(i);
    }
    
    
    public int cal(int arr[], int left, int right, int k)
    {
        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (arr[mid] <= k)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        int i = left;
        
        if (i > 0 && arr[i] != k)
        {
            return -1;
        }
        
        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < k)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        int j = right;
        return i - j - 1;
    }
    
    
    public int binarySerach(int arr[], int left, int right, int k)
    {
        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == k)
            {
                return mid;
            } else
            {
                if (arr[mid] < k)
                {
                    left = mid + 1;
                } else if (arr[mid] > k)
                {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
}
