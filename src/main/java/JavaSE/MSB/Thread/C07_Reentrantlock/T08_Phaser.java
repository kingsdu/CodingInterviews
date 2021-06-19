package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;


//结合了CountDownLatch 和 CyclicBarrier
//Phaser阶段，按照不同的阶段对线程进行执行
//CyclicBarrier是循环的栅栏，这个是一个个不断的栅栏
public class T08_Phaser
{
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();
    
    public static void main(String[] args)
    {
        phaser.bulkRegister(5);//设置限制5个线程
        for (int i = 0; i < 5; i++)
        {
            final int nameIndex = i;
            new Thread(() ->
            {
                Person p = new Person("person " + nameIndex);
                p.arrive();
                phaser.arriveAndAwaitAdvance();//所有线程完成后自动调用onAdvance()中对应的阶段
                
                p.eat();
                phaser.arriveAndAwaitAdvance();
                
                p.leave();
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
    }
    static class MarriagePhaser extends Phaser
    {
        @Override
        protected boolean onAdvance(int phase, int registeredParties)
        {
            switch (phase)
            {
                case 0:
                    System.out.println("所有人到齐了！");
                    return false;
                case 1:
                    System.out.println("所有人吃完了！");
                    return false;
                case 2:
                    System.out.println("所有人离开了！");
                    System.out.println("婚礼结束！");
                    return true;
                default:
                    return true;
            }
        }
    }
    
    static class Person
    {
        String name;
        
        public Person(String name)
        {
            this.name = name;
        }
        
        public void arrive()
        {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
        }
        
        public void eat()
        {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
        }
        
        public void leave()
        {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
        }
    }
    
    static void milliSleep(int milli)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


