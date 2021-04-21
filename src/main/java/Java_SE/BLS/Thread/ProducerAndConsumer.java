package Java_SE.BLS.Thread;

public class ProducerAndConsumer {

    public static void main(String[] args){
        ResourcesGS r = new ResourcesGS();
        Producer p = new Producer(r);
        Consumer c = new Consumer(r);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
