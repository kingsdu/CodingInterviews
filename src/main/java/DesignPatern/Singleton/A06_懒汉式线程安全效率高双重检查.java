package DesignPatern.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class A06_懒汉式线程安全效率高双重检查
{
    //必须要加volatile，涉及Java的指令重排
    private static volatile A06_懒汉式线程安全效率高双重检查 INSTANCE; //JIT

    private A06_懒汉式线程安全效率高双重检查() {
    }

    public static A06_懒汉式线程安全效率高双重检查 getInstance() {
        if (INSTANCE == null) {//这次检查可以大幅度减少锁的使用率
            //双重检查
            synchronized (A06_懒汉式线程安全效率高双重检查.class) {
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new A06_懒汉式线程安全效率高双重检查();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(A06_懒汉式线程安全效率高双重检查.getInstance().hashCode());
            }).start();
        }
    }
}
