package DataStruct;

/**
 * 普通数组
 */
public class GeneralArray {

    private int[] array;
    private int size;
    private int nElem;


    public GeneralArray(int max){
        this.array = new int[max];
        this.size = max;
        this.nElem = 0;
    }

    /**
     * 增
     * @return
     */
    public boolean insert(int val){
        if(nElem == size){
            return false;
        }

        array[nElem] = val;
        nElem++;
        return true;
    }


    /**
     * 删除某个值
     * @param val
     * @return
     */
    public boolean deleteVal(int val){
        int j;
        for (j = 0; j < nElem; j++) {
            if(array[j] == val){
                break;
            }
        }

        if(nElem == size){
            for (int i = j; i<nElem-1; i++) {
                array[i] = array[i+1];
            }
        }else{
            for (int i = j;i<nElem;i++){
                array[i] = array[i+1];
            }
        }
        nElem--;
        return true;
    }


    /**
     * 查
     * @param val
     */
    public int find(int val){
        int i;
        for (i = 0; i < nElem; i++) {
            if(array[i] == val){
                break;
            }
        }

        if(i == nElem){
            return -1;
        }else {
            return i;
        }
    }


    public void printArray(){
        if(nElem == 0){
            return;
        }

        for (int i = 0; i < nElem; i++) {
            System.out.print(array[i]+" ");
        }
    }


    public void insertSort(int []array){
        for (int i = 1; i < nElem; i++) {
            int temp = array[i];
            int left = i-1;
            while (left >=0 && array[i] < array[left]){
                array[left+1] = array[left];
                left--;
            }
            array[left] = temp;
        }
    }


    public int binarySearch(int val){
        if(nElem < 0){
            return -1;
        }

        int start = 0;
        int end = nElem;

        while (start < end){
            int mid = (start + end) / 2;
            if(array[mid] == val){
                return mid;
            }else {
                if(array[mid] < val){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
