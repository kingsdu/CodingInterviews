package JavaSE.BLS.Thread.ProducerConsumer.Lock;

public class Producer_Lock implements Runnable{

    private ResourcesGS_Lock r;
    Producer_Lock(ResourcesGS_Lock r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.set("producer");
        }
    }
}
