package JavaSE.BLS.InnerClass.PartInnerClass;

public class A01_Outer
{
    int num = 3;
    
    void method()
    {
        int x = 2;
        class Inner
        {
            void show()
            {
                System.out.println("inner x="+x);
                System.out.println("outer num="+num);
            }
        }
        new Inner().show();
    }
    

}
