package JavaSE.BLS.Thread.ThreadCommunication;

import JavaSE.BLS.Thread.ThreadCommunication.Resource;

public class OutPutResource implements Runnable {

    private Resource r;

    OutPutResource(Resource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            synchronized (r) {
                System.out.println(r.name + r.sex);
            }
        }
    }
}



