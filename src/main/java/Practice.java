import java.util.*;

/**
 * 练习回忆之前学过的代码
 */
public class Practice {

    public static void main(String[] args) {
        Practice practice = new Practice();
        int []array = new int[]{8,5,9,12,6,23,16,7,13};
        practice.heapSort(array);
        for (int i :array
                ) {
            System.out.print(i+" ");
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int []array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


    public void selectSort(int []array){
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = k+1; j < array.length; j++) {
                 if(array[k] > array[j]){
                     k = j;
                 }
            }

            if(k != i){
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
    }
    
    
    public void insertSort(int []array){
        for (int i = 1; i < array.length; i++) {
            int left = i-1;
            int temp = array[i];

            while (left >= 0 && array[left] > temp){
                array[left + 1] = array[left];
                left --;
            }
            array[left+1] = temp;
        }
    }


    public int binarySearch(int[] array,int value){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = (low + high)/2;
            if(array[mid] == value){
                return mid;
            }else{
                if(array[mid] > value){
                    low = mid - 1;
                }else if(array[mid] < value){
                    high = mid + 1;
                }
            }
        }
        return -1;
    }


    public void shellSort(int []array){
        for (int gap = array.length/2; gap > 0 ; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j-gap>=0 && array[j] < array[j-gap]){
                    int temp = array[j-gap];
                    array[j-gap] = array[j];
                    array[j] = temp;
                    j-=gap;
                }
            }
        }
    }



    public void quickSort(int []array,int start,int end){
        if(start > end){
            return;
        }
        int base = array[start];
        int i = start;
        int j = end;
        while (i!=j){
            while (i<j && array[j]>base){
                j--;
            }

            while (i<j && array[i]<base){
                i++;
            }

            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[start] = array[i];
        array[i] = base;
        quickSort(array,start,i-1);
        quickSort(array,i+1,end);
    }




    public void merge_split(int []array,int start,int end,int []temp){
        if(start > end){
            return;
        }

        while (start < end){
            int mid = (start + end) / 2;
            merge_split(array,start,mid,temp);
            merge_split(array,mid+1,end,temp);
            merge_sort(array,start,mid,end,temp);
        }
    }



    public void merge_sort(int []array,int start,int mid,int end,int[] temp){
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i<=mid && j<=end){
            if(array[i] <= array[j]){
                temp[t++] = array[i];
            }else{
                temp[t++] = array[j];
            }
        }

        while (i<=mid){
            temp[t++] = array[i++];
        }

        while (j<=end){
            temp[t++] = array[j++];
        }

        t = 0;
        while (start <= end){
            array[start++] = array[t++];
        }
    }


    public void heapSort(int []array){
        if(array != null && array.length<=1){
            return;
        }

        buildMaxHeap(array);
        for (int i = array.length-1; i > 0 ; i--) {
            exchangeElements(array,0,i);
            maxHeap(array,i,0);
        }
    }

    private void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;

        for (int i = half; i >= 0 ; i--) {
            maxHeap(array, array.length, i);
        }
    }



    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int lastest = index;

        if(left < heapSize && array[index] < array[left]){
            lastest = left;
        }

        if(right < heapSize && array[lastest] < array[right]){
            lastest = right;
        }

        if(index != lastest){
            exchangeElements(array,index,lastest);
            maxHeap(array,heapSize,lastest);
        }
    }


    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}


