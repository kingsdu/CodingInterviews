package JavaSE.BLS.Polymorph.FuZi;

public class TestMain
{
    
    
    public static void main(String[] args)
    {
        Father f = new Child();
        //成员变量：f.num属于Father类型的调用，所以num = 3，当父类没有num时，编译报错
        System.out.println(f.num);
        //方法：因为存在继承的特性：父类的方法被子类重写
        f.show();
        //静态函数是直接绑定到所属的类上的，所以输出是father
        f.method();
        System.out.println(f.age);
        System.out.println("-------------------------------------------------------");
        Child c = new Child();
        System.out.println(c.num);
        c.show();
        c.method();
        System.out.println(c.age);
    }
}
