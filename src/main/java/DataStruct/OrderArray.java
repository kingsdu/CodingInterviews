package DataStruct;

/**
 * 有序数组
 */
public class OrderArray {

    public int[] array;
    public int nElem;
    public int size;

    public OrderArray(int size){
        array = new int[size];
        this.size = size;
        nElem = 0;
    }

    /**
     * 增加
     */
    public boolean insert(int val){
        if(nElem == size){
            return false;
        }

        int i;
        for (i = 0; i < nElem; i++) {
            if(array[i] > val){
                break;
            }
        }

        for (int j = nElem; j >i ; j--) {
            array[j] = array[j-1];
        }

        array[i] = val;
        nElem++;
        return true;
    }


    /**
     * 删
     * @param val
     * @return
     */
    public boolean delete(int val){
        int index = find(val);
        if(index == -1){
            return false;
        }

        if(nElem == size){
            for (int i = index; i < nElem-1 ; i++) {
                array[i] = array[i+1];
            }
        }else {
            for (int i = 0; i < nElem; i++) {
                array[i] = array[i+1];
            }
        }

        nElem--;
        return true;
    }


    /**
     * 查
     * @param val
     * @return
     */
    public int find(int val){
        if(nElem <= 0){
            return -1;
        }
        int start = 0;
        int end = nElem;

        while (start <= end){
            int mid = (start + end) / 2;
            if(array[mid] == val){
                return mid;
            }else {
                if(array[mid] < val){
                    start = mid+1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public void printArray(){
        if(nElem == 0){
            return;
        }

        for (int i = 0; i < nElem; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
