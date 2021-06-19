package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/*

1 Person类实现Runnable 接口，实现run方法
2 hug()方法限制了只有新郎新娘可以继续执行线程，其他的线程结束注册

 */
public class T09_Phaser2
{
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();
    
    public static void main(String[] args)
    {
        phaser.bulkRegister(7);
        //加上 新郎新娘 共7个人
        for (int i = 0; i < 5; i++)
        {
            new Thread(new Person("p" + i)).start();//这个直接在Person实现run方法
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }
    
    static class MarriagePhaser extends Phaser
    {
        @Override
        protected boolean onAdvance(int phase, int registeredParties)//栅栏满足条件，这个方法会被自动调用
        {
            switch (phase)//phase是写死的，0123，表示一个个阶段的完成;registeredParties由phaser.bulkRegister(7);的参数决定的
            {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }
    static class Person implements Runnable
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
            phaser.arriveAndAwaitAdvance();//让每个线程在当前阶段停止，所有线程都到齐，栅栏推到进入onAdvance，phase = 0
        }
        public void eat()
        {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
            phaser.arriveAndAwaitAdvance();//让每个线程在当前阶段停止，所有线程都到齐，栅栏推到进入onAdvance，phase = 1
        }
        public void leave()
        {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        private void hug()
        {
            if (name.equals("新郎") || name.equals("新娘"))
            {
                milliSleep(r.nextInt(1000));
                System.out.printf("%s 洞房！\n", name);
                phaser.arriveAndAwaitAdvance();//只是留下新郎、新娘
            } else
            {
                phaser.arriveAndDeregister();//除了新郎、新娘其他线程取消注册
//                phaser.register();//这个会继续向上加
            }
        }
        @Override
        public void run()
        {
            arrive();
            eat();
            leave();
            hug();
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


