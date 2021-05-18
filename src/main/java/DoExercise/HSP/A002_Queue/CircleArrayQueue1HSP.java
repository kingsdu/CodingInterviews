package DoExercise.HSP.A002_Queue;


import java.util.Scanner;

/**
 * 循环队列
 * <p>
 * 单向队列存在问题：随着元素在队列中的增加和移除，某个时刻，当队列中的rear==maxsize && front==rear 时，
 * 再继续新增元素时，会无法新增，而队列中前面的存储结构还有空余，所以需要用一种新的存储结构：循环队列来解决该问题。
 * <p>
 * 为充分利用向量空间，克服"假溢出"现象的方法是：将向量空间想象为一个首尾相接的圆环，并称这种向量为循环向量。
 * 存储在其中的队列称为循环队列（Circular Queue）。循环队列是把顺序队列首尾相连，把存储队列元素的表从逻辑上看成一个环，成为循环队列。
 */
//数组实现循环队列，add 和 get的操作都需要对 maxsize取模
public class CircleArrayQueue1HSP
{
    
    /**
     * 数组实现循环队列
     * @param args
     */
    public static void main(String[] args)
    {
        CircleArrayQueue1HSP arrayQueue = new CircleArrayQueue1HSP(10);
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
                    arrayQueue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = arrayQueue.getQueue();
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
    
    
    /**
     * 通过取模的方式实现
     * <p>
     * 主要利用了一个数字如何比取模的数小，取模后该数字不变。
     * 而当该数字和取模数字相当后取模为0，实现数组循环。
     * 假设环形数组的大小是4
     * 1%4 = 1
     * 2%4=2
     * 3%4=3
     * 上面的情况在操纵数据时，下标是和正常的下标一致
     * 4%4=0
     * 此时循环数组又为0
     * <p>
     * 难点是获得数组存在元素个数的计算方法
     * <p>
     * (rear + maxsize - front) % maxsize
     */
    private int[] arr;
    private int front;
    private int rear;
    private int maxsize;
    
    
    public CircleArrayQueue1HSP(int maxsize)
    {
        arr = new int[maxsize];
        this.maxsize = maxsize;
    }
    
    
    public boolean isFull()
    {
        return (rear + 1) % maxsize == front;
    }//判断数组是否满的条件很重要
    
    public boolean isEmpty()
    {
        return rear == front;
    }
    
    public void addQueue(int num)
    {
        if (isFull())
        {
            System.out.println("满了");
            return;
        }
        
        arr[rear] = num;
        rear = (rear + 1) % maxsize;//获取下次自增的位置，取模是为了保证循环
    }
    
    
    public int getQueue()
    {
        if (isEmpty())
        {
            System.out.println("空的");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % maxsize;//保存循环，需要取模
        return val;
    }
    
    public int getArrSize()
    {
        return (rear + maxsize - front) % maxsize;
    }
    
    public void showQueue()
    {
        
        if (isEmpty())
        {
            System.out.println("数组为空");
            return;
        }
        
        for (int i = front; i < front + getArrSize(); i++)
        {
            System.out.println(arr[i]);
        }
    }
    
    
}
