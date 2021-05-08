package JavaSE.BLS.ClassLoadSequence.NotInit;

public class NotInitMain
{
    public static void main(String[] args)
    {
        System.out.println(Child.val);//子类引用父类的静态字段，只会触发子类的加载、父类的初始化，不会导致子类初始化。
        Father[] father = new Father[4];//通过数组定义来引用类，不会触发此类的初始化。
        // 常量在编译阶段会进行常量优化，将常量存入调用类的常量池中，本质上并没有直接引用到定义常量的类，
        // 因此不会触发定义常量的类的初始化(即在调用static final类型常量时不会触发类的初始化操作，
        // 但若static final变量不属于编译器常量则依然会触发初始化操作)。
        System.out.println(Constant.HELLO);
    }
}
