package java_se.Thread;

public class OutPutResource implements Runnable {

    private Resource r;

    OutPutResource(Resource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            synchronized (r) {
                System.out.println(r.name + "::::::::::::::" + r.sex);
            }
        }
    }
}



