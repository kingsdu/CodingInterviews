package JavaSE.BLS.Thread;

public class Consumer implements Runnable{

    private ResourcesGS r;
    Consumer(ResourcesGS r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.out();
        }
    }
}
