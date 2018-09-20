package Java_SE.Thread;

public class ThreadCommunication {

    public static void main(String[] args) {
        Resource r = new Resource();

        InputResource in =  new InputResource(r);
        OutPutResource out = new OutPutResource(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
    }
}
