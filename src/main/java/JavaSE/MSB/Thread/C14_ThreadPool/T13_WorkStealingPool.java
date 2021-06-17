/**
 *
 */
package JavaSE.MSB.Thread.C14_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T13_WorkStealingPool
{
	public static void main(String[] args) throws IOException {
		//每个线程都维护这自己的一个队列,自己执行完毕后,可以从其他线程队列中拿一个添加到其队列中帮忙执行
		//这种方式就是线程间合作
		//加不加锁,看有没有多个线程同时执行
		//poll方法要加锁,push和pop本身只有一个线程执行不需要加锁
		ExecutorService service = Executors.newWorkStealingPool();//当某个线程的任务满了,会去拿其他的队列中拿没有执行完毕的线程帮助其执行
		System.out.println(Runtime.getRuntime().availableProcessors());

		service.execute(new R(1000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000)); //daemon
		service.execute(new R(2000));
		
		//由于产生的是精灵线程（守护线程、后台线程），主线程不阻塞的话，看不到输出
		System.in.read(); 
	}

	static class R implements Runnable {

		int time;

		R(int t) {
			this.time = t;
		}

		@Override
		public void run() {
			
			try {
				TimeUnit.MILLISECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(time  + " " + Thread.currentThread().getName());
			
		}

	}
}
