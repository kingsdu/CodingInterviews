package JianzhiOffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class Offer051_ConstructArr
{
    
    public static void main(String[] args)
    {
        int nums[] = new int[]{1,2,3,4,5};
        for (int i : constructArr(nums))
        {
            System.out.print(i+" ");
        }
    }
    
    public static int[] constructArr(int[] arr)
    {
        if (arr == null || arr.length == 0 || arr.length == 1)
        {
            return null;
        }
        
        int res[] = new int[arr.length];
        int tmp;
        for (int i = 0; i < res.length; i++)
        {
            tmp = 1;
            for (int j = 0; j < arr.length; j++)
            {
                if (i == j)
                {
                    continue;
                }
                tmp *= arr[j];
            }
            res[i] = tmp;
        }
        return res;
    }
    
    
}
