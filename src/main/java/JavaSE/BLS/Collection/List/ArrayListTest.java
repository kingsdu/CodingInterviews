package JavaSE.BLS.Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayListTest
{
    
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        arrayListTest(list);
        arrayListTest(synchronizedList(new ArrayList<>()));
    }
    

    
    private static List<Integer> synchronizedList(ArrayList<Integer> list)
    {
        return Collections.synchronizedList(list);
    }
    
    
    /**
     *
     * 测试结果，list线程不安全
     *
     */
    private static void arrayListTest(List<Integer> list)
    {
    
        ExecutorService es = Executors.newFixedThreadPool(100);
    
        for (int i = 0; i < 1000; i++)
        {
            es.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    list.add(1);
                }
            });
        }
        
        es.shutdown();
        
        while (true){
            if(es.isTerminated()){
                if(list.size() == 1000){
                    System.out.println("线程安全");
                }else {
                    System.out.println("线程不安全");
                }
                break;
            }
        }
    }
    
    
}
