package DataStructBook;

/**
 *
 */
public class Queue {

    private int maxSize;
    private int[] queryArray;
    private int front;
    private int rear;
    private int nItem;



    public Queue(int s){
        maxSize = s;
        queryArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItem = 0;
    }



    /**
     * 队尾插入元素
     * @param i
     */
    public void insert(int i){
        if(rear == maxSize-1){
            rear = -1;
        }
        queryArray[++rear] = i;
        nItem++;
    }


    /**
     * 对头删除元素
     * @return
     */
    public int remove(){
        int temp = queryArray[front++];
        if(front == maxSize){
            front = 0;
        }
        nItem --;
        return temp;
    }

    public int peekFront(){
        return queryArray[front];
    }

    public boolean isEmpty(){
        return nItem == 0;
    }

    public int getSize(){
        return nItem;
    }
}
