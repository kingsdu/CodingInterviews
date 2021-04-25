package JavaSE.BLS.InnerClass.PartInnerClass;

public class A02_AnonymousInnerClass
{
    int num = 3;
    
    public void method()
    {   //匿名内部类
        new A02_AbsDemo()
        {
            public void show()
            {
                System.out.println("outer num=" + num);
            }
        }.show();
    }
    
}
