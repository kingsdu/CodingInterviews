package JavaSE.Book.ClassLoadSequence;

public class Test
{
    /**
     *
     * 第一次调用：
     * 1、父类的静态变量 -- 父类的静态方法 -- 子类的静态变量 -- 子类的静态方法
     * 2、根据代码从上到下的顺序，执行父类的非静态方法或者非静态变量，构造函数在它们后调用
     *
     * 第二次调用
     * 1、因为静态变量已经初始化过了，第二次调用时，静态部分全部不调用，其他顺序不变。
     *
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SubClass subClass = new SubClass();
        subClass.add();
        
        System.out.println("----------------------------------------------------------");
        SubClass subClass1 = new SubClass();
        subClass1.add();
    }
    
    /**
     *
     *
     * 1、没有继承关系的三者的执行顺序：
     * 分别是静态 变量-----》静态的语句块-----》静态方法------》语句块（构造方法）执行的顺序
     *
     * 2、有继承关系的执行顺序大致的为父类的静态相关、子类的静态相关、父类的非静态相关、子类的非静态相关。
     * 静态相关的执行顺序和非继承关系中的执行顺序是一样的，先执行静态变量、静态语句块、静态方法。
     *
     *
     */
}
