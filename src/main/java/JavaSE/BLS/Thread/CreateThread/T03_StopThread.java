package JavaSE.BLS.Thread.CreateThread;

public class T03_StopThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 280; i++) {
            System.out.println(Thread.currentThread().toString()+"...run"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T03_StopThread stopThread = new T03_StopThread();

        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        t1.start();
        t1.join();//
        t2.start();

        for (int i = 0; i < 280; i++) {
            System.out.println(Thread.currentThread().toString()+"...main"+i);
        }
    }
}


