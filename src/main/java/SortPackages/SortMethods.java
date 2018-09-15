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
     *
     * https://www.cnblogs.com/bjh1117/p/8335628.html
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
     *
     * https://www.cnblogs.com/bjh1117/p/8335628.html
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
            //二层，基于增量的向前递进，遍历外岑，用于循环比较
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



    /**
     *
     * 找到一个基数，基数左边所有数比其小，右边所有数比其大。
     * 不断分割迭代，直至其有序
     *
     * https://blog.csdn.net/yzllz001/article/details/50982841
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int []array,int left,int right){
        int i,j,t,temp;
        if(left > right){
            return;
        }

        temp = array[left];
        i = left;
        j = right;
        while(i!=j){
            while(array[j] >= temp && i<j){
                j--;
            }

            while(array[i]<=temp && i<j){
                i++;
            }

            if(i<j){
                t=array[i];
                array[i]=array[j];
                array[j]=t;
            }

        }

        array[left] = array[i];
        array[i] = temp;
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
    }


    /**
     * 归并排序
     *
     * 归并排序分为两个部分：
     * 1 分治 ：将一段数据不断分割到一个字段
     * 2 归并：分割为都只剩下一个数字时，就1V1的比较一个数字，并将排序结果存入到临时数组中。
     *
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     *
     */
    /**分治*/
    public static void mergeSort_sort(int []arr,int start,int end,int []temp){
        if(end < start){
            return;
        }

        if(start<end){
            int mid = (start+end)/2;
            mergeSort_sort(arr,start,mid,temp);//左边归并排序，使得左子序列有序
            mergeSort_sort(arr,mid+1,end,temp);
            mergeSort_merge(arr,start,mid,end,temp);//将两个有序子数组合并操作
        }
    }


    /**
     * 归并
     * 将两个已经有序的数组，提供逐一比较，归并至临时数组中。
     *
     */
    public static void mergeSort_merge(int[] arr,int start,int mid,int end,int[] temp){
        int i = start;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }

        while(j<=end){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }

        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(start <= end){
            arr[start++] = temp[t++];
        }
    }





}
