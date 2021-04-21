package JavaSE.Book.ClassLoadSequence;

public class SubClass extends Parent
{
    Member member = new Member("SubClass的非静态成员");
    static Member smember = new Member("SubClass的静态成员");
    
    static
    {
        System.out.println("SbuClass的静态代码块");
    }
    
    public SubClass()
    {
        System.out.println("SubClass的无参数构造方法");
    }
    
    {
        System.out.println("SbuClass非静态码块");
    }
    
    
    public void add(){
        System.out.println("aaa");
    }
}
