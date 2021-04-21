package JavaSE.Book.Inherit;

public class Parent {

    public int a = 1;
    public static int b = 1;

    public Parent(){
        System.out.println("Parent is created");
    }

    {
        System.out.println("parent no static");
    }

    static{
        System.out.println("parent static");
    }

    protected void method(){
        System.out.println("parent method");
    }

    public void m(){
        this.method();
    }
}


