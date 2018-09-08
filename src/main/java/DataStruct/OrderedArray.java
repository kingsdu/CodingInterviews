package DataStruct;

/**
 * 有序数组
 * 实现：find、insert、delete功能
 */
public class OrderedArray {

    private int[] source;
    private int size;
    private int nElem;

    public OrderedArray(int size){
        this.source = new int[size];
        this.size = size;
        this.nElem = 0;
    }

    /**
     * 插入有序数组，由于数组本身是有序的
     * 所以需要通过排序的方式先找到位置
     * 在进行插入
     * @param value
     * @return
     */
    public boolean insert(int value){
        if(size == nElem){
            return false;
        }
        int i;
        for(i=0;i<nElem;i++){
            if(source[i] > value){
                break;
            }
        }

        for(int k=nElem;k>i;k--){
            source[k] = source[k-1];
        }

        source[i] = value;
        nElem++;
        return true;
    }


    /**
     *
     * 提供二分查找，获取查找值在数组中的下标位置
     * @param value
     * @return
     */
    public int binarySerach(int value){
        int low = 0;
        int upper = nElem -1;
        int curr;
        while (true){
            curr = (low + upper)/2;
            if(source[curr] == value){
                return curr;
            }
            else if(low>upper){
                return -1;
            }else{
                if(source[curr] < value){
                    low = curr + 1;
                }else{
                    upper = curr - 1;
                }
            }
        }
    }


    public boolean delete(int value){
        int curr = binarySerach(value);
        if(curr == -1){
            return false;
        }
        //数组内元素个数 == size时
        if(nElem == size){
            for(int k=curr;k<nElem-1;k++){
                source[k] = source[k+1];
            }
            source[nElem-1]=0;
        }else{
            for (int k=curr;k<nElem;k++){
                source[k] = source[k+1];
            }
        }
        nElem--;
        return true;
    }

}
