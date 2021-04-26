package JavaSE.BLS.Thread.ThreadCommunication;

public class ThreadCommunication_1 {

    public static void main(String[] args) {
        Resource r = new Resource();

        InputResource_1 in =  new InputResource_1(r);
        OutPutResource_1 out = new OutPutResource_1(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
    }
}
