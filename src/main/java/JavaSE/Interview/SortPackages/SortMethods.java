package JavaSE.Interview.SortPackages;

/**
 * 常用排序算法汇总
 */
public class SortMethods {
    

    /**
     * 插入排序
     * 稳定性：不稳定
     * 平均情况：O(n*n)
     *
     * 分析：
     * 找到一个插入点，使得插入点左边的值都比插入点的值小，右边的值都比插入点大。
     * 算法的关键就是插入点的移动，赋值。
     *
     * https://www.cnblogs.com/bjh1117/p/8335628.html
     */
    public static void insertSort(int []source){
        for (int i = 1; i < source.length; i++) {
            int temp = source[i];
            int leftIndex = i-1;
            while(leftIndex>=0 && source[leftIndex]>temp){
                source[leftIndex+1] = source[leftIndex];
                leftIndex--;
            }
            source[leftIndex+1] = temp;
        }
    }


    /**
     * 二分查找
     */
    public static int binarySearch(int []array,int low,int high,int value){
        if(low>high || value<array[low] || value>array[high]){
            return -1;
        }
        int mid = (low+high)/2;

        while (true){
            if(array[mid] == value){
                return mid;
            }else{
                if(array[mid] > value){
                    return binarySearch(array,low,mid,value);
                }else {
                    return binarySearch(array,mid+1,high,value);
                }
            }
        }
    }


    /**
     * 非递归方式
     */
    public static int binarySearch(int[] array,int value){
        int low = 0;
        int heigh = array.length-1;

        while (low <= heigh){
            int mid = (low + heigh) / 2;
            if(array[mid] == value){
                return mid;
            }else{
                if(array[mid] < value){
                    low = mid + 1;
                }else {
                    heigh = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     *
     * 第一层：控制gap
     * 第二层：自增
     * 第三层：交换，--
     *
     * @param array
     */
    public void shellSort(int []array){
        for (int gap = array.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j-gap >=0 && array[j] < array[j-gap]){
                    int temp = array[j];
                    array[j] = array[j-gap];
                    array[j-gap] = temp;
                    j-=gap;
                }
            }
        }
    }


    /**
     * 希尔排序：缩小增量排序，跳跃分割的策略
     * O(NlogN)
     * 排序效率依赖于依赖于增量序列的选取。
     * 不稳定
     * @param data
     * @return
     *
     * https://blog.csdn.net/jianyuerensheng/article/details/51258460
     */
    public static int[] shellSortSmallToBig(int[] data){
        int j;
        int temp;
        /***
         * 三层循环
         * 第一层：切分，控制增量间隔
         */
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            //二层，基于增量的向前递进，遍历外层，用于循环比较
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                //三层，基于增量进行比较，遍历内层
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                //由于多减了一次，此处+increment
                data[j + increment] = temp;
            }
        }
        return data;
    }



   
   


  




}
