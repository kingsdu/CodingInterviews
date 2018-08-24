package java_se.Thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeadLockTest {

    @Test
    public void deadLcok() {
        Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));

        t1.start();
        t2.start();
    }
}