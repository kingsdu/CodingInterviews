package JavaSE.BLS.Thread;

/**
 * 生产者和消费者的例子来说明多线程通讯存在的问题
 */
public class ResourcesGS {

    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name +"---"+ count++;
        System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"........消费者......."+this.name);
        flag = false;
        this.notifyAll();
    }
}
