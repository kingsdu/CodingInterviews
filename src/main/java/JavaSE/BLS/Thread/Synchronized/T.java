package JavaSE.BLS.Thread.Synchronized;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * Java 中的普通对象存储在内存中的存储布局
 *
 * markword
 * 类型指针（class pointer）
 * 实例数据（instance data）
 * 对其（padding:补位，让其可以被8整除）
 *
 *
 */
public class T
{
    private static Object o = new Object();
    
    /**
     *
     * 锁的不同的状态是记录在markword中
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
    
}
