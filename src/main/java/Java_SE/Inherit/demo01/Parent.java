package Java_SE.Inherit.demo01;

import org.w3c.dom.ls.LSOutput;

public class Parent
{
   
    static Member smember = new Member("Parent的静态成员");
    
    static
    {
        System.out.println("Parent的静态代码块");
    }
    
    public Parent()
    {
        System.out.println("Parent的构造方法");
    }
    
    //放的顺序在前就执行，放在下面的非静态代码后面，就后执行
    Member member = new Member("Parent的非静态成员");
    
    {
        System.out.println("Parent的非静态代码块");
    }
    
    
}
