package JavaSE.BLS.Thread.ForkJoinTask;

import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class A02_ForkJoinTaskDemo
{
    public static void main(String[] args)
    {
        Integer count = new ForkJoinPool().invoke(new A02_ReadDicFiles(Paths.get("D:\\software\\Listary")));
        System.out.println("文件总数:"+count);
    }
}
