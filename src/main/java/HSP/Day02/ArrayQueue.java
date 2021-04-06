package HSP.Day02;

public class ArrayQueue
{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arraySize)
    {
        maxSize = arraySize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }


    public boolean isFull()
    {
        return rear == maxSize - 1;
    }

    public boolean isEmpty()
    {
        return rear == front;
    }

    public void addQueue(int target)
    {
        if (isFull())
        {
            System.out.println("队列已满");
            return;
        }

        rear++;
        arr[rear] = target;
    }


    public int getQueue()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
        }
        front++;
        return arr[front];
    }


    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空");
        }

        for (int num :
                arr)
        {
            System.out.print(num+" ");
        }
    }

}
