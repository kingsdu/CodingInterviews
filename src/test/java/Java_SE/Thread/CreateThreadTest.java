package Java_SE.Thread;

import org.junit.Test;

public class CreateThreadTest {

    /**
     * 启动多线程的第一种方式
     */
    @Test
    public void run_method_1() {
        CreateThread_1 t1 = new CreateThread_1();
        CreateThread_1 t2 = new CreateThread_1();
        CreateThread_1 t3 = new CreateThread_1();
        CreateThread_1 t4 = new CreateThread_1();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    /**
     * 启动多线程的第二种方式
     */
    @Test
    public void run_method_2() {
        CreateThread_2 thread = new CreateThread_2();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        Thread t4 = new Thread(thread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}