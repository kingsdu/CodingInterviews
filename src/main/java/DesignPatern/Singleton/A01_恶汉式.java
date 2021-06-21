package DesignPatern.Singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class A01_恶汉式
{//JVM保证只能初始化一次，所以线程安全
    private static final A01_恶汉式 INSTANCE = new A01_恶汉式();

    private A01_恶汉式() {};

    public static A01_恶汉式 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        A01_恶汉式 m1 = A01_恶汉式.getInstance();
        A01_恶汉式 m2 = A01_恶汉式.getInstance();
        System.out.println(m1 == m2);
    }
}
