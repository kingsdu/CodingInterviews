package DoExercise.HSP.A002_Queue;


import java.util.Scanner;

/**
 *
 * 队列：队列是一个有序列表，可以用数组或是链表来实现。遵循先入先出的原则。即：先存入队列的数据，要先取出，后存入的要后取出。
 *
 * 队列（queue）是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作，和栈一样，
 * 队列是一种操作受限制的线性表。进行插入操作的端称为队尾，进行删除操作的端称为队头。队列中没有元素时，称为空队列。
 *
 * 队列的数据元素又称为队列元素。在队列中插入一个队列元素称为入队，从队列中删除一个队列元素称为出队。
 * 因为队列只允许在一端插入，在另一端删除，所以只有最早进入队列的元素才能最先从队列中删除，
 * 故队列又称为先进先出（FIFO—first in first out）线性表。
 *
 * 队列分为：
 *
 * 　　①、单向队列（Queue）：只能在一端插入数据，另一端删除数据。
 * 　　②、双向队列（Deque）：每一端都可以进行插入数据和删除数据操作。
 *
 * 在计算机中也可以在队列中删除一个数之后，队列整体向前移动，但是这样做效率很差。
 * 我们选择的做法是移动队头front和队尾rear的指针。
 *
 *
 */
// 数组实现单向队列
public class OneWayQueueHSP
{
    
    /**
     *
     * 顺序数组实现队列
     *
     * @param args
     */
    public static void main(String[] args)
    {
        OneWayQueueHSP oneWayQueueHSP = new OneWayQueueHSP(10);
        Scanner sc = new Scanner(System.in);
        char key = ' ';//用户输入
        boolean flag = true;
        while (flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    oneWayQueueHSP.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    oneWayQueueHSP.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = oneWayQueueHSP.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    sc.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;//数组

    public OneWayQueueHSP(int arraySize)
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
            return -1;
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
