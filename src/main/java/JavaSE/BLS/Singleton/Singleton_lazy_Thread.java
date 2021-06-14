package JavaSE.BLS.Singleton;

/**
 * @Author: Du
 * @Date: 2021/6/14 19:47
 *
 * 懒汉多线程模式
 *
 * 你听说过单例模式吗
 * 知道要双重检查吗
 * 你觉得需要加volatile吗
 *
 * 答案：需要
 *
 * 不加volatile在指令重排序时会出问题
 */
public class Singleton_lazy_Thread
{
    private Singleton_lazy_Thread()
    {
    
    }
    
    private static /*volatile*/ Singleton_lazy_Thread INSTANCE;
    
    public static Singleton_lazy_Thread getInstance()
    {
        if (INSTANCE == null)
        {
            //双重检查
            synchronized (Singleton_lazy_Thread.class)
            {
                if (INSTANCE == null)
                {
                    try
                    {
                        Thread.sleep(1);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    //1 申请内存 2 内存变量赋初值 3 内存指向引用地址
                    //存在指令重排序后，1 2 3 的顺序可能会改变
                    INSTANCE = new Singleton_lazy_Thread();
                }
            }
        }
        return INSTANCE;
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            new Thread(()->{
                System.out.println(Singleton_lazy_Thread.getInstance().hashCode());
            }).start();
        }
    }
    
}
