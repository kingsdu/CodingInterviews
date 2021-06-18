package DoExercise.HSP_ZCY.A024_二分;

/**
 * @Author: Du
 * @Date: 2021/6/12 11:59
 *
 *
 * 求局部最小使用二分：求一个存在局部最小数字数列中的一个局部最小数。相邻的数字一定不相等。
 *
 * 表明二分不一定是有序才行，只要保证求取的数的一侧一定有数字，就可以二分
 */
public class C03_BSAwesome
{
    
    public static void main(String[] args)
    {
        int maxLen = 10;
        int maxValue = 20;
        int testTimes = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++)
        {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans))
            {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }
    
    
    public static int oneMinIndex(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        int N = arr.length;
        //1个数、2个数字的情况
        if (N == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[N - 1] < arr[N - 2]) return N - 1;
        //超过3个数字的情况
        int L = 0;
        int R = N - 1;
        while (L < R - 1) // 保证LR范围内一定有三个数字，如果<三个数字直接比较L和R，返回小的。 否则使用L<R 在3 2 3 2 3的情况会出错。
        {
            int mid = (L + R) >> 1;
            //mid是局部最小
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
            {
                return mid;
            } else
            {
                // 1 左 > cur cur > 右
                // 2 左 < cur cur < 右
                // 3 左 < cur cur > 右
                if (arr[mid] > arr[mid - 1])
                {
                    R = mid - 1;
                } else
                {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }
    
    //生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue)
    {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        if (len > 0)
        {
            ans[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++)
            {
                do
                {
                    ans[i] = (int) (Math.random() * maxValue);
                } while (ans[i] == ans[i - 1]);//保证相邻不相等
                
            }
        }
        return ans;
    }
    
    //用于测试，midIndex位置是局部最小，其左右都比其大
    public static boolean check(int[] arr, int minIndex)
    {
        if (arr.length == 0) return minIndex == -1;
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }
    
    
    public static void printArray(int[] arr)
    {
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    
}
