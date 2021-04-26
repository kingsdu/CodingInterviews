package JavaSE.BLS.Thread.CreateThread;

import java.util.concurrent.Callable;


/**
 *
 * 创建线程的方法3：实现方式是implement callable，调用call()方法。
 *
 */
public class CreateThread_Method3 implements Callable<String>{

    public String call() throws Exception {
        Thread.sleep(500l);
        return "CreateThread_Method3";
    }
    
}
