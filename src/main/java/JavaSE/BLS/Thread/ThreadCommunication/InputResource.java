package JavaSE.BLS.Thread.ThreadCommunication;

public class InputResource implements Runnable {

    private Resource r;

    InputResource(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) {
                if (x == 0) {
                    r.name = "james";
                    r.sex = "man";
                } else {
                    r.name = "丽丽";
                    r.sex = "女";
                }
                x = (x + 1) % 2;
            }
        }
    }
}



