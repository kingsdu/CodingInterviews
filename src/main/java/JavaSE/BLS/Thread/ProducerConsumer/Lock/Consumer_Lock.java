package JavaSE.BLS.Thread.ProducerConsumer.Lock;

public class Consumer_Lock implements Runnable{

    private ResourcesGS_Lock r;
    Consumer_Lock(ResourcesGS_Lock r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.out();
        }
    }
}
