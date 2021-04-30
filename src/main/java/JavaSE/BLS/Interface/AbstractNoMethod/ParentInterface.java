package JavaSE.BLS.Interface.AbstractNoMethod;

/**
 * 抽象类中不写方法抽象方法的原因；
 *
 *
 * 防止实现一个接口时，实现类中反复需要实现不需要的接口方法。
 * 正确的做法是：用一个类（作为父类）去实现一个接口（多个方法），
 * 再用具体实现的子类继承实现接口的父类，子类就可以只重写父类中的需要用的方法，减少无用代码的书写。
 *
 * 比如 Java.io.FilterReader
 * 就是一个只有没有抽象方法的抽象类，抽象类中的非抽象方法是没有实现具体的逻辑的，只有各种return
 * 因为真正的逻辑在继承 FilterReader 的类中根据自己需求实现的。
 *
 */
public abstract class ParentInterface implements Interface001
{
    @Override
    public void add()
    {
        System.out.println("ParentInterface -- add");
    }
    
    @Override
    public void edit()
    {
        System.out.println("ParentInterface -- edit");
    }
    
    @Override
    public void delete()
    {
        System.out.println("ParentInterface -- delete");
    }
    
    @Override
    public void list()
    {
        System.out.println("ParentInterface -- list");
    }
}
