package JavaSE.MSB.Thread.C13_Interview2;


public class T03_00_Volatile_CAS
{
    enum ReadyToRun {T1, T2}//用枚举防止取其他的值

    static volatile ReadyToRun r = ReadyToRun.T1; //思考为什么必须volatile，为了保证线程的可见性，T1修改后T2可以里面看到

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r != ReadyToRun.T1) {}
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (r != ReadyToRun.T2) {}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();
    }
}


