package DataStruct;

import java.util.concurrent.ArrayBlockingQueue;

public class Queue {

    private int[] queueArray;
    private int maxSize;
    private int rear;
    private int front;
    private int nItems;

    public Queue(int size){
        maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }


    /**
     * @param val
     * @return
     */
    public void insert(int val){
        //队列满
        if(rear == maxSize-1){
            rear = -1;
        }
        queueArray[++rear] = val;
        nItems++;
    }


    /**
     * 删除元素
     */
    public int remove(){
        int index = queueArray[front++];
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return index;
    }


    /**
     * 查看元素
     * @return
     */
    public int peekFont(){
        if(isEmpty()){
            return -1;
        }
        return queueArray[front];
    }


    public boolean isEmpty(){
        return (nItems == 0);
    }


    public boolean isFull(){
        return nItems == maxSize;
    }


    public void dispalyQueue(){
        if(isEmpty()){
            return;
        }

        while (isEmpty()){
            int remove = remove();
            System.out.print(remove);
        }
    }
}
