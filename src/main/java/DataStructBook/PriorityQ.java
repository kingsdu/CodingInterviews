package DataStructBook;

/**
 *
 */
public class PriorityQ {

    private int maxSize;
    private int[] queArry;
    private int nItems;

    public PriorityQ(int s){
        maxSize = s;
        queArry = new int[maxSize];
        nItems = 0;
    }

    public void insert(int val){
        int j;
        if(nItems == 0){
            queArry[nItems++] = val;
        }else{
            for (j = nItems-1; j >=0 ; j--) {
                if(val > queArry[j]){
                    queArry[j+1] = queArry[j];
                }else{
                    break;
                }
            }
            queArry[j+1] = nItems;
            nItems++;
        }
    }
}
