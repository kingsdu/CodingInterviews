package JavaSE.BLS.Thread.ThreadCommunication;

import JavaSE.BLS.Thread.ThreadCommunication.Resource;

public class OutPutResource_1 implements Runnable {

    private Resource r;

    OutPutResource_1(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r) {
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name + "::::::::::::::" + r.sex);
                r.flag = false;
                r.notify();
            }
        }
    }
}
