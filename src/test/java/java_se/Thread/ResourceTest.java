package java_se.Thread;

import org.junit.Test;

public class ResourceTest {

    @Test
    public void ThreadCommunication(){
        Resource r = new Resource();

        InputResource in =  new InputResource(r);
        OutPutResource out = new OutPutResource(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
    }
}