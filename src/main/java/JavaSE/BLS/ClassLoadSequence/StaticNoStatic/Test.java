package JavaSE.BLS.ClassLoadSequence.StaticNoStatic;

/**
 * @Author: Du
 * @Date: 2021/7/7 6:59
 *
 *
 * 1 和 2 谁写在前面，先执行谁
 *
 * 1在前面，执行顺序：3 2
 * 2在前面，执行顺序: 2 3
 *
 * static的部分只执行一次
 */
public class Test
{
    {//3
        System.out.println("blockA");
    }
    
    public static Test t1 = new Test();//1
    
    static//2
    {
        System.out.println("blockB");
    }

    
    public static void main(String[] args)
    {
        Test t2 = new Test();
        Test t3 = new Test();
    }
}