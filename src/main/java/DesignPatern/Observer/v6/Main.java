package DesignPatern.Observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 */

class Child//被观察者
{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
    
    public boolean isCry()
    {
        return cry;
    }
    
    public void wakeUp()
    {
        cry = true;
        
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");
        
        for (Observer o : observers)
        {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类 fire Event
class wakeUpEvent//事件本身（小孩哭的时间本身的情况）
{
    long timestamp;
    String loc;
    
    public wakeUpEvent(long timestamp, String loc)//记录小孩哭的具体情况
    {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer
{
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer
{
    public void feed()
    {
        System.out.println("dad feeding...");
    }
    
    @Override
    public void actionOnWakeUp(wakeUpEvent event)
    {
        feed();
    }
}

class Mum implements Observer
{
    public void hug()
    {
        System.out.println("mum hugging...");
    }
    
    @Override
    public void actionOnWakeUp(wakeUpEvent event)
    {
        if (event.loc.equals("bed"))
            hug();
    }
}

class Dog implements Observer
{
    public void wang()
    {
        System.out.println("dog wang...");
    }
    
    @Override
    public void actionOnWakeUp(wakeUpEvent event)
    {
        wang();
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
