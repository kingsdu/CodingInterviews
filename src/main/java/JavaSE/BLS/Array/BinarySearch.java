package JavaSE.BLS.Array;


/**
 * 二分查找
 */
public class BinarySearch
{
    
    
    
    public static void main(String[] args)
    {
//        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        BinarySearch bi = new BinarySearch();
//        int i = bi.binarySearch(num, 0, num.length, 6);
//        System.out.println(i);
        
        int a = -10;
        System.out.println(a >>> 26);
    }
    
    /**
     * 二分查找算法默认一般返回数组下标索引
     * 没找到返回-1
     *
     * @return
     */
    public int binarySearch(int[] num, int i, int j, int target)
    {
        
        int mid = (i + j) >> 1;
        
        if (target < num[mid])
        {
            return binarySearch(num,i,mid,target);
        } else if (target > num[mid])
        {
            return binarySearch(num,mid+1,j,target);
        } else
        {
            return mid;
        }
    }
    
    
}
