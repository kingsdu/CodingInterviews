package JavaSE.BLS.Polymorph.Person;

public class TestPerson
{
    
    public static void main(String[] args)
    {
        Person p = new Zhangsan();//多态
        p.eat();//调用的是父类的方法，但是子类重写了父类的方法
        p.bellow();//调用父类方法
        //p.watchingTV();//无法调用子类的方法。
        Zhangsan p1 = (Zhangsan) p;
        if (p1 instanceof Zhangsan)
        {
            p1.watchingTV();
        }
    }
}
