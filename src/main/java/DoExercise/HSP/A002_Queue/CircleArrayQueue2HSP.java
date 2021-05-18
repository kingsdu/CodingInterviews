package DoExercise.HSP.A002_Queue;


import java.util.Scanner;

/**
 * 循环队列实现方法2
 * <p>
 * 单向队列存在问题：随着元素在队列中的增加和移除，某个时刻，当队列中的rear==maxsize && front==rear 时，
 * 再继续新增元素时，会无法新增，而队列中前面的存储结构还有空余，所以需要用一种新的存储结构：循环队列来解决该问题。
 * <p>
 * 为充分利用向量空间，克服"假溢出"现象的方法是：将向量空间想象为一个首尾相接的圆环，并称这种向量为循环向量。
 * 存储在其中的队列称为循环队列（Circular Queue）。循环队列是把顺序队列首尾相连，把存储队列元素的表从逻辑上看成一个环，成为循环队列。
 *
 * //https://www.cnblogs.com/ysocean/p/7921930.html
 */
// 使用itemCount作为计数工具，每次add itemCount+1，get itemCount-1；
public class CircleArrayQueue2HSP
{
    /**
     *
     * 顺序数组实现队列
     *
     * @param args
     */
    public static void main(String[] args)
    {
        CircleArrayQueue2HSP arrayQueue = new CircleArrayQueue2HSP(10);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    arrayQueue.addElement(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = arrayQueue.getElement();
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
    
    
    private int[] arr;
    private int maxsize;
    private int rear;
    private int front;
    private int itemCount;//计数，记录数组中元素的个数
    
    public CircleArrayQueue2HSP(int maxsize)
    {
        this.arr = new int[maxsize];
        this.rear = 0;
        this.front = 0;
        this.itemCount = 0;
    }
    
    
    public boolean isFull()
    {
        return maxsize == itemCount;
    }
    
    
    public boolean isNull()
    {
        return itemCount == 0;
    }
    
    public void addElement(int element)
    {
        if (isFull())
        {
            System.out.println("满了");
        } else
        {
            if (rear == maxsize)
            {
                rear = 0;
            }
            arr[rear++] = element;
            itemCount++;
        }
    }
    
    
    public int getElement()
    {
        if (isNull())
        {
            System.out.println("空了");
            return -1;
        } else
        {
            int number = arr[front++];
            itemCount--;
            if(front == maxsize){
                front = 0;
            }
            return number;
        }
    }
    
    
    public void showQueue()
    {
        
        if (isNull())
        {
            System.out.println("数组为空");
            return;
        }
        
        for (int i = front; i < itemCount; i++)
        {
            System.out.println(arr[i]);
        }
    }
    
    
}
