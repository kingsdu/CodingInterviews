package JavaSE.MSB.Thread.C04_Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 */
public class T03_VolatileNotSync
{
	volatile int count = 0;
	void m() {
		//29581 因为Volatile只有可见性但是没有原子性，所以无法返回10000
		for(int i=0; i<10000; i++) count++;
	}
	
	public static void main(String[] args) {
		T03_VolatileNotSync t = new T03_VolatileNotSync();
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<10; i++) {
			threads.add(new Thread(t::m, "thread-"+i));
		}
		threads.forEach((o)->o.start());
		threads.forEach((o)->{
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(t.count);
	}
	
}


