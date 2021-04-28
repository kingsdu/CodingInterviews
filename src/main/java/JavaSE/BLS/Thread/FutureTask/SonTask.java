package JavaSE.BLS.Thread.FutureTask;

import java.util.concurrent.Callable;

public class SonTask implements Callable<String>
{
    private String name = "";
    
    public SonTask(String name){
        this.name = name;
    }
    
    @Override
    public String call() throws Exception
    {
        Thread.sleep(1000l);
        System.out.println(name+" 任务完成");
        return "result";
    }
}
