package DesignPatern.Observer.v4;

/**
 * 加入多个观察者
 */

class Child
{
    private boolean cry = false;
    private Dad dad = new Dad();//观察者1
    private Mum mum = new Mum();//观察者2
    private Dog dog = new Dog();//观察者3
    
    public boolean isCry()
    {
        return cry;
    }
    
    public void wakeUp()
    {
        cry = true;
        dad.feed();//每个观察者的处理方式不同
        dog.wang();
        mum.hug();
    }
}

class Dad
{
    public void feed()
    {
        System.out.println("dad feeding...");
    }
}

class Mum
{
    public void hug()
    {
        System.out.println("mum hugging...");
    }
}

class Dog
{
    public void wang()
    {
        System.out.println("dog wang...");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}
