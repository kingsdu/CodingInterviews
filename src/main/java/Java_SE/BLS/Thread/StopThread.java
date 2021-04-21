package Java_SE.BLS.Thread;

public class StopThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 280; i++) {
            System.out.println(Thread.currentThread().toString()+"...run"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();

        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        t1.start();
        t1.join();
        t2.start();

        for (int i = 0; i < 280; i++) {
            System.out.println(Thread.currentThread().toString()+"...main"+i);
        }
    }
}


