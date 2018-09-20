package DataStructBook;

/**
 * 通过代码实现普通数据结构
 * 包括：find、insert、delete功能
 */
public class GeneralArray {

    private int[] source;
    private int size;
    private int nElem;

    public GeneralArray(int max){
        this.source = new int[max];
        this.size = max;
        this.nElem = 0;
    }


    public boolean find(int searchNum){
        int i;
        for(i=0;i<nElem;i++){
            if(source[i] == searchNum){
               return true;
            }
        }
        return false;
    }


    public boolean insert(int value){
        if(nElem == size){
            return false;
        }
        source[nElem] = value;
        nElem++;
        return true;
    }


    public boolean delete(int value){
        int i;
        for (i=0;i<nElem;i++){
            if(source[i] == value){
                break;
            }
        }

        if(i == nElem){
            return false;
        }

        if(nElem == size){
            for(int k=i;k<nElem-1;k++){
                source[k] = source[k+1];
            }
        }else{
            for(int k=i;k<nElem;k++){
                source[k] = source[k+1];
            }
        }
        nElem--;
        return true;
    }

}
