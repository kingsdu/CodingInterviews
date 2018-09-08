package SortPackages;

/**
 * 常用排序算法汇总
 */
public class SortMethods {


    /**
     * 冒泡排序
     * 稳定性(相同的值，排序前排序后位置不变):稳定
     * 空间复杂度：1
     * 平均情况：O(n*n)
     */
    public void bubbleSort(int []source){
        for(int i=0;i<source.length-1;i++){
            for(int j=0;j<source.length-1-i;j++){
                if(source[j] > source[j+1]){
                    int temp = source[j];
                    source[j] = source[j+1];
                    source[j+1] = temp;
                }
            }
        }
    }


    /**
     * 选择排序
     * 选择排序改进了冒泡排序，将必要的交换次数从O(n2)减少到O(n)，但是比较次数仍保持为O(n2)。
     * 冒泡排序每比较一次就可能交换一次，但是选择排序是将一轮比较完后，把最小的放到最前的位置。
     *
     * 稳定性：不稳定
     * 平均情况：O(n*n)
     * 空间复杂度：1
     *
     * 我没写出来的地方：1 和谁比较：j和k比较；
     */
    public void selectSort(int []source){
        for (int i = 0; i < source.length-1; i++) {
            int k = i;
            for (int j = k+1; j < source.length; j++) {
                if(source[j] < source[k]){
                    k = j;
                }
            }

            if(i != k){
                int temp = source[i];
                source[i] = source[k];
                source[k] = temp;
            }
        } 
    }


    /**
     * 插入排序
     */
    public void insertSort(int []source){
        for (int i = 1; i < source.length; i++) {
            int temp = source[i];
            int leftIndex = i-1;
            while(leftIndex>=0 && source[leftIndex]>temp){
                source[leftIndex+1] = source[leftIndex];
                leftIndex--;
            }
            source[leftIndex] = temp;
        }
    }


    /**
     * 不稳定
     * @param data
     * @return
     * https://blog.csdn.net/jianyuerensheng/article/details/51258460
     */
    public static int[] shellSortSmallToBig(int[] data){
        int j;
        int temp;
        // 1 控制间隔增量；2 内层循环的起始位置；3 循环每次递减的增量
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
        return data;
    }


    /**
     * 选择一个关键值作为基准值。
     * 比基准值小的都在左边序列（一般是无序的），比基准值大的都在右边（一般是无序的）
     *
     *
     * @param a
     * @param low
     * @param high
     */
    /**
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int divide(int[] a, int start, int end){
        int base = a[end];
        while(start < end){
            while(start < end && a[start] <= base)
                start++;
            if(start < end){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                end--;
            }
            while(start < end && a[end] >= base)
                end--;
            if(start < end){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
            }

        }
        return end;
    }


    /**
     * 排序
     * @param a
     * @param start
     * @param end
     */
    public static void fastSort(int[] a, int start, int end){
        if(start > end){
            return;
        }
        else{
            int partition = divide(a, start, end);
            fastSort(a, start, partition-1);
            fastSort(a, partition+1, end);
        }

    }






}
