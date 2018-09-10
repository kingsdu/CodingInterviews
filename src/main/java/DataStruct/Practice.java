package DataStruct;

/**
 * 练习回忆之前学过的代码
 */
public class Practice {

    public static void main(String[] args) {
        int[] arr = {7,6,9,8,4,3};
        Practice.mergeSort_split(arr,0,arr.length-1,new int[arr.length]);
        for (int i :
                arr) {
            System.out.print(i);
        }
    }



    public static void mergeSort_split(int []array,int low,int high,int []temp){
        if(low > high){
            return;
        }

        if(low < high){
            int mid = (low+high)/2;
            mergeSort_split(array,low,mid,temp);
            mergeSort_split(array,mid+1,high,temp);
            mergeSort_merge(array,low,mid,high,temp);
        }
    }


    public static void mergeSort_merge(int []array,int low,int mid,int high,int []temp){
        if(low > high){
            return;
        }

        int i = low;
        int j = mid+1;
        int t = 0;
        while( i <= mid && j<= high){
            if(array[i] <= array[j]){
                temp[t++] = array[i++];
            }else{
                temp[t++] = array[j++];
            }
        }

        while( i <= mid){
            temp[t++] = array[i++];
        }

        while (j<= high){
            temp[t++] = array[j++];
        }

        t = 0;
        while (low <= high){
            array[low++] = temp[t++];
        }
    }


}
