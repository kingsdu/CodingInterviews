package DesignPatern.Observer.v3;

/**
 * 加入观察者
 */

class Child
{
    private boolean cry = false;
    private Dad d = new Dad();//观察者
    
    public boolean isCry()
    {
        return cry;
    }
    
    public void wakeUp()
    {
        cry = true;
        d.feed();//调用观察者的处理方式
    }
}

class Dad//观察者
{
    public void feed()
    {
        System.out.println("dad feeding...");
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
