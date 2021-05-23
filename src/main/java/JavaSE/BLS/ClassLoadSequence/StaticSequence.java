package JavaSE.BLS.ClassLoadSequence;


/**
 *
 * 重点：
 * 1、顺序执行
 * 2、static静态代码块只执行一次
 *
 */
public class StaticSequence
{
    public static StaticSequence t1 = new StaticSequence();
    
    {
        System.out.println("blockA");
    }
    
    static
    {
        System.out.println("blockB");
    }
    
    public static void main(String[] args)
    {
        StaticSequence t2 = new StaticSequence();
    }
    
    
}




