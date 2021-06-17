package JavaSE.BLS.Collection.A01MSB.A03_Map;

import java.util.concurrent.LinkedTransferQueue;

//使用场景：例如付账：要等待付账完成后，确认后才能反馈
public class T09_TransferQueue
{
    public static void main(String[] args) throws InterruptedException
    {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
        new Thread(() ->
        {
            try
            {
                System.out.println(strs.take());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();
        strs.transfer("aaa");//和put的区别，transfer装完元素，线程会在这里等着，等到其他元素取走后，线程才会返回
        //除了put外还有transfer功能
//        strs.put("aaa");
//        new Thread(() ->
//        {
//            try
//            {
//                System.out.println(strs.take());
//            } catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
