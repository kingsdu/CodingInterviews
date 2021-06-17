
package JavaSE.BLS.Thread.A00MSB.C14_ThreadPool;

import java.util.concurrent.*;

public class T06_00_Future
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        
        FutureTask<Integer> task = new FutureTask<>(() ->
        {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        }); //new Callable () { Integer call();}
        
        new Thread(task).start();
        
        System.out.println(task.get());
        
//        ExecutorService service = Executors.newFixedThreadPool(5);
//		Future<Integer> f = service.submit(() ->
//		{
//			TimeUnit.MILLISECONDS.sleep(500);
//			return 1;
//		});
//		System.out.println(f.get());
		
    }
}
