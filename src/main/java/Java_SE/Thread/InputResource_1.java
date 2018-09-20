package Java_SE.Thread;

public class InputResource_1 implements Runnable {

    private Resource r;

    InputResource_1(Resource r) {
        this.r = r;
    }


    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) {
                if (r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //首先执行false，赋值操作
                if (x == 0) {
                    r.name = "james";
                    r.sex = "man";
                } else {
                    r.name = "丽丽";
                    r.sex = "女";
                }
                x = (x + 1) % 2;
                r.flag = true;//flag置为true之后，output被notify，input被wait
                r.notify();
            }
        }
    }
}
