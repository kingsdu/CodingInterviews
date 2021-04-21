package JavaSE.BLS.Thread;

import java.util.concurrent.Callable;

public class CreateThread_3 implements Callable<String>{

    public String call() throws Exception {
        String str = "was111";
//        System.out.println(str);
        return str;
    }


}
