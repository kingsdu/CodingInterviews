package Java_SE.Thread;

public class Producer implements Runnable{

    private ResourcesGS r;
    Producer(ResourcesGS r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.set("producer");
        }
    }
}
