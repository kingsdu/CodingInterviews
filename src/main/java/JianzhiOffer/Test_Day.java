package JianzhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 * 0 1 1 2 3 5 8 13 21
 * 输入 4，输出 3
 * <p>
 * <p>
 * 斐波那契数列：这个数列从第3项开始，每一项都等于前两项之和。
 * An = An-1 + An-2
 */
public class Test_Day
{
    public static void main(String[] args)
    {
        Test_Day t = new Test_Day();
        int nums[] = {2,2,3,4,4,4,4,1,2,3};
        System.out.println(t.minArray(nums));
    }
    
    
    public int minArray(int[] numbers)
    {
        if (null == numbers || numbers.length == 0)
        {
            return 0;
        }
        
        int left = 0, right = numbers.length - 1;
        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] == numbers[right])
            {
                return numbers[mid];
            } else
            {
                if (numbers[mid] < numbers[right])
                {
                    right = mid;
                } else
                {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    
    
}
