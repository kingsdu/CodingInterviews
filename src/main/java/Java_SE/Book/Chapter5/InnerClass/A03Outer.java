package Java_SE.Book.Chapter5.InnerClass;

public class A03Outer
{
    private class A03InnerA extends A03ParentA
    {
        public String name()
        {
            return super.getName();
        }
    }
    
    private class A03InnerB extends A03ParentB
    {
        public int age()
        {
            return super.getAge();
        }
    }
    
    public String name()
    {
        return new A03InnerA().name();
    }
    
    public int age()
    {
        return new A03InnerB().age();
    }
    
}